package com.kubertX.austinX.common.domain;

import java.io.Serializable;

public class ChannelAccount implements Serializable {
    private Long id;

    /** 账号名称 */
    private String name;

    /** 消息发送渠道：10.IM 20.Push 30.短信 40.Email 50.公众号 60.小程序 70.企业微信 80.钉钉机器人 90.钉钉工作通知 100.企业微信机器人 110.飞书机器人 110. 飞书应用消息  */
    private Byte sendChannel;

    /** 账号配置 */
    private String accountConfig;

    /** 拥有者 */
    private String creator;

    /** 创建时间 */
    private Integer created;

    /** 更新时间 */
    private Integer updated;

    /** 是否删除：0.不删除 1.删除 */
    private Byte isDeleted;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSendChannel() {
        return sendChannel;
    }

    public void setSendChannel(Byte sendChannel) {
        this.sendChannel = sendChannel;
    }

    public String getAccountConfig() {
        return accountConfig;
    }

    public void setAccountConfig(String accountConfig) {
        this.accountConfig = accountConfig;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getUpdated() {
        return updated;
    }

    public void setUpdated(Integer updated) {
        this.updated = updated;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", sendChannel=").append(sendChannel);
        sb.append(", accountConfig=").append(accountConfig);
        sb.append(", creator=").append(creator);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}