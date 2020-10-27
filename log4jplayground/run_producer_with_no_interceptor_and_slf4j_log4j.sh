#!/bin/bash
mvn --file use_slf4j_and_no_interceptor.xml clean package
mvn --file use_slf4j_and_no_interceptor.xml -q exec:java \
    -Dexec.mainClass="com.nateneff.log4jplayground.TestProducer" \
    -Dexec.args="localhost:9092 fake_topic DONT_USE_INTERCEPTOR" \
    -Dlog4j.configuration=file:src/main/resources/log4j.properties
