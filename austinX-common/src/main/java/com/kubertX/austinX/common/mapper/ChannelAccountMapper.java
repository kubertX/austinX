package com.kubertX.austinX.common.mapper;

import com.kubertX.austinX.common.domain.ChannelAccount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChannelAccountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelAccount row);

    int insertSelective(ChannelAccount row);

    ChannelAccount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelAccount row);

    int updateByPrimaryKey(ChannelAccount row);

    List<ChannelAccount> list();

    List<ChannelAccount> queryByChannelType(@Param("channelType") Integer channelType);
}