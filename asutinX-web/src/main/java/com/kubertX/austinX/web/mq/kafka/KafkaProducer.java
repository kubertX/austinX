package com.kubertX.austinX.web.mq.kafka;

import com.alibaba.fastjson.JSON;
import com.kubertX.austinX.web.constants.KafkaConstants;
import com.kubertX.austinX.web.vo.MessageTemplateParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;


    public void send2Kafka(MessageTemplateParam messageTemplateParam){
        log.info("kafka producer send msg:{}",JSON.toJSONString(messageTemplateParam));
        kafkaTemplate.send(KafkaConstants.TOPIC_TEST, JSON.toJSONString(messageTemplateParam));

    }

}
