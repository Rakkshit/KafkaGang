package com.example.kafkagang.porducer;

import com.example.kafkagang.Employee;
import com.example.kafkagang.binder.TestBinder;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@EnableBinding({TestBinder.class})
public class TestProducer {

    @Autowired
    private TestBinder testBinder;

//    @Autowired
//    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(Employee myArg){
        try {
            //kafkaTemplate.send("Shanta",myArg);
            MessageBuilder messageBuilder = MessageBuilder.withPayload(myArg).setHeader("kafka_messageKey","1234");
            Message message = messageBuilder.build();
            testBinder.output().send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String doIt()
    {
        String name = "Shanta";
        String ret=name;
        try
        {

            Properties properties = new Properties();
            // Kafka Properties
            properties.setProperty("bootstrap.servers", "http://localhost:9092");
            properties.setProperty("acks", "all");
            properties.setProperty("retries", "10");
            // Avro properties
            properties.setProperty("key.serializer", StringSerializer.class.getName());
            properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
            properties.setProperty("schema.registry.url", "http://localhost:8081");

            sendMsg(properties, name);
        }
        catch(Exception ex){ ret+="<br>"+ex.getMessage();}

        return ret;
    }

    private Employee sendMsg(Properties properties, String topic)
    {
        Producer<String, Employee> producer = new KafkaProducer<String, Employee>(properties);

        Employee employee = Employee.newBuilder().setFirstName("Kripa").setLastName("Nepal").setPhoneNumber("123").build();

        ProducerRecord<String, Employee> producerRecord = new ProducerRecord<String, Employee>(topic, employee);


        producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception == null) {
                    System.out.println(metadata);
                } else {
                    System.out.println(exception.getMessage());
                }
            }
        });

        producer.flush();
        producer.close();

        return employee;
    }
}
