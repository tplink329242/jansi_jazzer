#!/bin/sh

export JAVA_HOME="/usr/lib/jvm/java-1.11.0-openjdk-amd64"

./jazzer --cp=jni.jar --target_class="CursorTest" --coverage_report="report.log"
