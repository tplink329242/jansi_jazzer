import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicReference;

import org.fusesource.jansi.io.AnsiOutputStream;
import org.fusesource.jansi.io.AnsiProcessor;

import org.fusesource.jansi.AnsiColors;
import org.fusesource.jansi.AnsiMode;
import org.fusesource.jansi.AnsiType;

import com.code_intelligence.jazzer.api.FuzzedDataProvider;

public class PrintStreamTest 
{
    public static void fuzzerTestOneInput(FuzzedDataProvider data) 
    {
        String input = data.consumeRemainingAsString();

        try {

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final AtomicReference<String> newLabel = new AtomicReference<String>();
            PrintStream ansi = new PrintStream(new AnsiOutputStream(baos, null, AnsiMode.Default, new AnsiProcessor(baos) {
                @Override
                protected void processChangeWindowTitle(String label) {
                    newLabel.set(label);
                }
            }, AnsiType.Emulation, AnsiColors.TrueColor, Charset.forName("UTF-8"), null, null, false), true, "UTF-8");

            ansi.print(input);
            ansi.flush();
            
        } catch (Exception e) {
            return;
        }

    }
}

