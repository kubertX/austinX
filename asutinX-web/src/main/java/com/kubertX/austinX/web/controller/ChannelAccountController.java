package com.kubertX.austinX.web.controller;

import com.kubertX.austinX.common.domain.ChannelAccount;
import com.kubertX.austinX.web.convert.Convert4Amis;
import com.kubertX.austinX.web.service.ChannelAccountService;
import com.kubertX.austinX.web.vo.BasicResultVO;
import com.kubertX.austinX.web.vo.amis.CommonAmisVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 渠道账号管理接口
 */
@RestController
@RequestMapping("/account")
public class ChannelAccountController {

    @Autowired
    private ChannelAccountService channelAccountService;
    @PostMapping("save")
    public BasicResultVO<ChannelAccount> save(@RequestBody ChannelAccount account){


        return new BasicResultVO<>("0","success",channelAccountService.save(account));
    }

    @GetMapping("list")
    public BasicResultVO<List<ChannelAccount>> list(){
        return new BasicResultVO<>(channelAccountService.list());
    }


    @GetMapping("/queryByChannelType")
    public BasicResultVO<List<CommonAmisVo>> queryByChannelType(@RequestParam Integer channelType){
        List<ChannelAccount> list = channelAccountService.queryByChannelType(channelType);


        return new BasicResultVO<>(Convert4Amis.getChannelAccountVo(list, channelType));
    }
}
