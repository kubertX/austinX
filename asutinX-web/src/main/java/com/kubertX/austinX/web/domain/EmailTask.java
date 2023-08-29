package com.kubertX.austinX.web.domain;


import com.kubertX.austinX.web.service.EmailSendService;
import com.kubertX.austinX.web.vo.MessageTemplateParam;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class EmailTask implements Runnable{

    @Autowired
    private EmailSendService service;

    private MessageTemplateParam taskInfo;

    @Override
    public void run() {
        if(taskInfo != null){
            service.send(taskInfo);
        }
    }
}
