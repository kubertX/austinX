package com.kubertX.austinX.web.service;

import com.kubertX.austinX.web.constants.CommonConstant;
import com.kubertX.austinX.web.utils.RedisUtils;
import com.kubertX.austinX.web.vo.MessageTemplateParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.UUID;

@Service
@Slf4j
public class DeduplicationService {


    private static final String DEDUPLICATION_KEY = "DEDUPLICATION";

    private static final String REDIS_LUA_SCRIPT = "limit.lua";


    private DefaultRedisScript<Long> redisScript;

    @Autowired
    private RedisUtils redisUtils;

    @PostConstruct
    public void init(){
        redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource(REDIS_LUA_SCRIPT)));
    }


    /**
     * 重复数据删除
     * @param messageTemplateParam
     */
    public void deduplication(MessageTemplateParam messageTemplateParam){
        // 生成唯一key
        String key = DEDUPLICATION_KEY + messageTemplateParam.getId()
                + CommonConstant.COLON + messageTemplateParam.getReceiver();
        String score = String.valueOf(System.currentTimeMillis());
        String timeGap = String.valueOf(60* 1000);
        String count = "2";
        String scoreValue = UUID.randomUUID().toString();
        if(redisUtils.execLimitLua(redisScript, Collections.singletonList(key),timeGap,score,count,scoreValue)){
            log.info("deduplication filter key :{}",key);
            messageTemplateParam.setReceiver("");
        }

    }
}
