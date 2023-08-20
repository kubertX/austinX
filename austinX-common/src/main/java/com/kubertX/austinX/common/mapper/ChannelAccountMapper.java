package com.kubertX.austinX.common.mapper;

import com.kubertX.austinX.common.domain.ChannelAccount;

public interface ChannelAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelAccount row);

    int insertSelective(ChannelAccount row);

    ChannelAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelAccount row);

    int updateByPrimaryKey(ChannelAccount row);
}