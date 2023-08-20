package com.kubertX.austinX.common.mapper;

import com.kubertX.austinX.common.domain.SmsRecord;


public interface SmsRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SmsRecord row);

    int insertSelective(SmsRecord row);

    SmsRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SmsRecord row);

    int updateByPrimaryKey(SmsRecord row);
}