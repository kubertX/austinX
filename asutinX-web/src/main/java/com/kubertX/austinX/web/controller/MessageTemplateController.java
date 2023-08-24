package com.kubertX.austinX.web.controller;


import cn.hutool.json.JSONUtil;
import com.github.pagehelper.PageInfo;
import com.kubertX.austinX.common.domain.MessageTemplate;
import com.kubertX.austinX.web.convert.Convert4Amis;
import com.kubertX.austinX.web.service.MessageTemplateService;
import com.kubertX.austinX.web.service.SendService;
import com.kubertX.austinX.web.vo.BasicResultVO;
import com.kubertX.austinX.web.vo.MessageTemplateParam;
import com.kubertX.austinX.web.vo.MessageTemplateVo;
import com.kubertX.austinX.web.vo.SendResponse;
import com.kubertX.austinX.web.vo.amis.CommonAmisVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/messageTemplate")
public class MessageTemplateController {

    @Autowired
    private MessageTemplateService messageTemplateService;

    @Autowired
    private SendService sendService;

    @GetMapping("list")
    public BasicResultVO<MessageTemplateVo> list(MessageTemplateParam param){
        log.info("list:{}", JSONUtil.toJsonStr(param));
        PageInfo<MessageTemplate> page = messageTemplateService.page(param);
        List<Map<String, Object>> result = Convert4Amis.flatListMap(page.getList());
        MessageTemplateVo templateVo = MessageTemplateVo.builder().count(page.getTotal()).rows(result).build();
        return new BasicResultVO(templateVo);
    }

    @PostMapping("save")
    public BasicResultVO<MessageTemplate> save(@RequestBody MessageTemplate param){
        log.info("save:{}",JSONUtil.toJsonStr(param));
        return new BasicResultVO<>(messageTemplateService.save(param));
    }


    @PostMapping("test/content")
    public BasicResultVO<CommonAmisVo> testContent(Long id){
        log.info("testContent:{}",id);
        MessageTemplate messageTemplate = messageTemplateService.queryById(id);
        return new BasicResultVO<>(Convert4Amis.getTestContent(messageTemplate.getMsgContent()));
    }

    @PostMapping("test")
    public BasicResultVO<SendResponse> test(@RequestBody MessageTemplateParam messageTemplateParam){
        log.info("testContent:{}",JSONUtil.toJsonStr(messageTemplateParam));

        return new BasicResultVO<>(sendService.send(messageTemplateParam));
    }




}
