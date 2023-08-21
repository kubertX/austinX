package com.kubertX.austinX.web.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kubertX.austinX.common.domain.MessageTemplate;
import com.kubertX.austinX.common.mapper.MessageTemplateMapper;
import com.kubertX.austinX.web.service.MessageTemplateService;
import com.kubertX.austinX.web.vo.MessageTemplateParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MessageTemplateServiceImpl implements MessageTemplateService {

    @Autowired
    private MessageTemplateMapper mapper;
    @Override
    public MessageTemplate save(MessageTemplate messageTemplate) {
        mapper.insertSelective(messageTemplate);
        return messageTemplate;
    }

    @Override
    public PageInfo<MessageTemplate> page(MessageTemplateParam param) {
        PageHelper.startPage(param.getPage(),param.getPerPage());
        List<MessageTemplate> list = mapper.list();
        PageInfo<MessageTemplate> page = new PageInfo<>(list);
        return page;
    }
}
