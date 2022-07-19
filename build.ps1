#OpenJDK-11

# Cusor Test
javac CursorTest.java
jar cvf jni.jar CursorTest.class org
#./jazzer --cp=jni.jar --target_class="CursorTest" --coverage_report="report.log"

# PrintStreamTest
javac PrintStreamTest.java
jar cvf jni_print.jar 'PrintStreamTest.class' 'PrintStreamTest$1.class' com org
#./jazzer --cp=jni_print.jar --target_class="PrintStreamTest" --coverage_report="report.log"