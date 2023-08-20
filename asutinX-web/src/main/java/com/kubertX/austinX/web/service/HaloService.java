package com.kubertX.austinX.web.service;

import com.kubertX.austinX.common.domain.MessageTemplate;
import com.kubertX.austinX.common.mapper.MessageTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HaloService {

    @Autowired
    private MessageTemplateMapper mapper;

    public MessageTemplate get(){
        return mapper.selectByPrimaryKey(1L);
    }
}
