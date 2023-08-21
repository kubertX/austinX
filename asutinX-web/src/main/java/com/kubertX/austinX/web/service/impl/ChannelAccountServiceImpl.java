package com.kubertX.austinX.web.service.impl;

import cn.hutool.json.JSONUtil;
import com.kubertX.austinX.common.domain.ChannelAccount;
import com.kubertX.austinX.common.mapper.ChannelAccountMapper;
import com.kubertX.austinX.web.service.ChannelAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ChannelAccountServiceImpl implements ChannelAccountService {

    @Autowired
    private ChannelAccountMapper accountMapper;
    @Override
    public ChannelAccount save(ChannelAccount account) {
        account.setCreator("root");
        int insert = accountMapper.insertSelective(account);
        log.info("save after:{}", JSONUtil.toJsonStr(account));
        return account;
    }

    @Override
    public List<ChannelAccount> list() {
        return accountMapper.list();
    }

    @Override
    public List<ChannelAccount> queryByChannelType(Integer channelType) {
        return accountMapper.queryByChannelType(channelType);
    }
}
