package com.nateneff.log4jplayground;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;
import org.apache.log4j.Logger;

public class TestProducer {
    
    private final Logger logger = Logger.getLogger(TestProducer.class);
    
    private final KafkaProducer<String, String> producer;
    private final Properties props;
    private final String topic;
    private long messagesSent = 0;
    
    public TestProducer(String bootstrapServers, String topic, String useInterceptor) {
        this.topic = topic;
        this.props = new Properties();
        props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "test-producer");
        if (useInterceptor == "USE_INTERCEPTOR") {
            props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,
                "com.hortonworks.smm.kafka.monitoring.interceptors.MonitoringProducerInterceptor");
        }
        
        props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        
        this.producer = new KafkaProducer<>(props);
    }
    
    public static void main(String[] args) {
        String bootstrapServers = args[0];
        String topic = args[1];
        String useInterceptor = args[2];
        TestProducer bssp = new TestProducer(bootstrapServers, topic, useInterceptor);
    }
}
