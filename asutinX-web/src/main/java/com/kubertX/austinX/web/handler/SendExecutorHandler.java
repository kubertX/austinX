package com.kubertX.austinX.web.handler;

import com.kubertX.austinX.web.enums.ChannelTypeEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class SendExecutorHandler {

    private Map<ChannelTypeEnum, ExecutorService> executorMap = new HashMap<>();
    public SendExecutorHandler(){
        for (ChannelTypeEnum value : ChannelTypeEnum.values()) {
            ExecutorService service = Executors.newFixedThreadPool(100);
            executorMap.put(value,service);
        }
    }


    public ExecutorService getExecutorService(ChannelTypeEnum channelType){
        return executorMap.get(channelType);
    }
}
