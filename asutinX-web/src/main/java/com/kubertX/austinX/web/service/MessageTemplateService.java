package com.kubertX.austinX.web.service;

import com.github.pagehelper.PageInfo;
import com.kubertX.austinX.common.domain.MessageTemplate;
import com.kubertX.austinX.web.vo.MessageTemplateParam;

public interface MessageTemplateService {

    MessageTemplate save(MessageTemplate messageTemplate);

    PageInfo<MessageTemplate> page(MessageTemplateParam param);

    MessageTemplate queryById(Long id);
}
