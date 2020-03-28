#!/bin/bash
# Output file should be in the file described in 
#    -Dlog4j.configuration=file:src/main/resources/log4j.properties.different.output.file
mvn -q exec:java \
    -Dexec.mainClass="com.nateneff.log4jplayground.Family" \
    -Dexec.args="" \
    -Dlog4j.configuration=file:src/main/resources/log4j.properties.different.output.file
