package com.kubertX.austinX.web.service;

import com.kubertX.austinX.web.domain.EmailTask;
import com.kubertX.austinX.web.enums.ChannelTypeEnum;
import com.kubertX.austinX.web.handler.SendExecutorHandler;
import com.kubertX.austinX.web.mq.kafka.KafkaProducer;
import com.kubertX.austinX.web.vo.MessageTemplateParam;
import com.kubertX.austinX.web.vo.SendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class SendService {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SendExecutorHandler sendExecutorHandler;

    @Autowired
    private EmailSendService emailSendService;

    @Autowired
    private KafkaProducer kafkaProducer;

    @Autowired
    private DeduplicationService deduplicationService;

    public SendResponse send(MessageTemplateParam messageTemplateParam){
        return emailSendService.send(messageTemplateParam);
    }

    public SendResponse send2Pool(MessageTemplateParam messageTemplateParam){
        SendResponse response = new SendResponse("0","");
        //

        EmailTask task = applicationContext.getBean(EmailTask.class);
        task.setTaskInfo(messageTemplateParam);
        ExecutorService executorService = sendExecutorHandler.getExecutorService(ChannelTypeEnum.EMAIL);
        executorService.execute(task);
        return response;
    }

    public SendResponse send2Kafka(MessageTemplateParam messageTemplateParam){
        kafkaProducer.send2Kafka(messageTemplateParam);
        SendResponse response = new SendResponse("0","");
        return response;
    }
}
