#!/bin/sh

export JAVA_HOME="/usr/lib/jvm/java-1.11.0-openjdk-amd64"

cd /root/jansi_jazzer/

nohup sh run_printstream.sh > full.log 2>&1 &

python3 extract_log.py 1800 $0
