#!/bin/bash
mvn -q exec:java \
    -Dexec.mainClass="com.nateneff.log4jplayground.Family" \
    -Dexec.args="" \
    -Dlog4j.configuration=file:src/main/resources/log4j.properties
