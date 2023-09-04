package com.kubertX.austinX.web.mq.kafka;

import com.alibaba.fastjson.JSON;
import com.kubertX.austinX.web.constants.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {


    @KafkaListener(topics = KafkaConstants.TOPIC_TEST,containerFactory = "ackContainerFactory")
    public void receive(ConsumerRecord record, Acknowledgment acknowledgment){
        log.info("kafka consumer receive msg :{}", record.toString());
        try {
            String value = (String) record.value();
            log.info("business msg:{}",value);
        }catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            // 手动提交 offset
            acknowledgment.acknowledge();
        }
    }
}
