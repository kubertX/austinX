package com.kubertX.austinX.web.service;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kubertX.austinX.common.domain.ChannelAccount;
import com.kubertX.austinX.common.domain.MessageTemplate;
import com.kubertX.austinX.web.vo.MessageTemplateParam;
import com.kubertX.austinX.web.vo.SendResponse;
import com.sun.mail.util.MailSSLSocketFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SendService {

    @Autowired
    private MessageTemplateService messageTemplateService;

    @Autowired
    private ChannelAccountService channelAccountService;

    public SendResponse send(MessageTemplateParam messageTemplateParam){
        SendResponse response = new SendResponse("0","");

        try {
            MessageTemplate messageTemplate = messageTemplateService.queryById(messageTemplateParam.getId());
            sendEmail(messageTemplate,messageTemplateParam);
        }catch (Exception e){

        }
        return response;

    }


    private void sendEmail(MessageTemplate messageTemplate,MessageTemplateParam param){
        MailAccount account = getAccountConfig(messageTemplate.getSendAccount());
        JSONObject jsonObject = JSON.parseObject(messageTemplate.getMsgContent());
        String title = jsonObject.getString("title");
        String content = jsonObject.getString("content");
        long start = System.currentTimeMillis();
        String result = MailUtil.send(account, param.getReceiver(), title, content, true);
        long end = System.currentTimeMillis();
        //### cost:925 ms
        log.info("### cost:{} ms",end-start);
        // result:<771728157.1.1692892530543@localhost>
        log.info("result:{}",result);
    }


    private MailAccount getAccountConfig(Integer sendAccount) {
        MailAccount account = getAccountById(sendAccount, MailAccount.class);
        log.info("mailaccount:{}",JSON.toJSONString(account));
        try {
            MailSSLSocketFactory sf = new MailSSLSocketFactory();
            sf.setTrustAllHosts(true);
            account.setAuth(account.isAuth()).setStarttlsEnable(account.isStarttlsEnable()).setSslEnable(account.isSslEnable()).setCustomProperty("mail.smtp.ssl.socketFactory", sf);
            account.setTimeout(25000).setConnectionTimeout(25000);
        } catch (Exception e) {
            log.error("EmailHandler#getAccount fail!{}", e);
        }
        return account;
    }

    public <T> T getAccountById(Integer sendAccountId, Class<T> clazz) {
        try {
            ChannelAccount channelAccount = channelAccountService.queryById(Long.valueOf(sendAccountId));
            //Optional<ChannelAccount> optionalChannelAccount = channelAccountDao.findById(Long.valueOf(sendAccountId));
            if (channelAccount != null) {

               /* if (clazz.equals(WxMaService.class)) {
                    return (T) ConcurrentHashMapUtils.computeIfAbsent(miniProgramServiceMap, channelAccount, account -> initMiniProgramService(JSON.parseObject(account.getAccountConfig(), WeChatMiniProgramAccount.class)));
                } else if (clazz.equals(WxMpService.class)) {
                    return (T) ConcurrentHashMapUtils.computeIfAbsent(officialAccountServiceMap, channelAccount, account -> initOfficialAccountService(JSON.parseObject(account.getAccountConfig(), WeChatOfficialAccount.class)));
                } else {
                    return JSON.parseObject(channelAccount.getAccountConfig(), clazz);
                }*/
                    return JSON.parseObject(channelAccount.getAccountConfig(), clazz);
            }
        } catch (Exception e) {
            log.error("AccountUtils#getAccount fail! e:{}", e);
        }
        return null;
    }
}
