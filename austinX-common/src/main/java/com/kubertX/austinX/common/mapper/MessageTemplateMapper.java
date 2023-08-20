package com.kubertX.austinX.common.mapper;

import com.kubertX.austinX.common.domain.MessageTemplate;

public interface MessageTemplateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessageTemplate row);

    int insertSelective(MessageTemplate row);

    MessageTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageTemplate row);

    int updateByPrimaryKey(MessageTemplate row);
}