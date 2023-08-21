package com.kubertX.austinX.web.service;

import com.kubertX.austinX.common.domain.ChannelAccount;

import java.util.List;

public interface ChannelAccountService {

    ChannelAccount save(ChannelAccount account);

    List<ChannelAccount> list();

    List<ChannelAccount> queryByChannelType(Integer channelType);
}
