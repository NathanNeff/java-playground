#!/bin/bash
mvn --file use_log4j_over_slf4j_and_interceptor.xml clean package
mvn --file use_log4j_over_slf4j_and_interceptor.xml -q exec:java \
    -Dexec.mainClass="com.nateneff.log4jplayground.TestProducer" \
    -Dexec.args="localhost:9092 fake_topic USE_INTERCEPTOR" \
    -Dlog4j.configuration=file:src/main/resources/log4j.properties
