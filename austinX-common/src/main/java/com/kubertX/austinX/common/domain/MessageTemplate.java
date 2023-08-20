package com.kubertX.austinX.common.domain;

import java.io.Serializable;

public class MessageTemplate implements Serializable {
    private Long id;

    /** 标题 */
    private String name;

    /** 当前消息审核状态： 10.待审核 20.审核成功 30.被拒绝 */
    private Byte auditStatus;

    /** 工单ID */
    private String flowId;

    /** 当前消息状态：10.新建 20.停用 30.启用 40.等待发送 50.发送中 60.发送成功 70.发送失败 */
    private Byte msgStatus;

    /** 定时任务Id (xxl-job-admin返回) */
    private Long cronTaskId;

    /** 定时发送人群的文件路径 */
    private String cronCrowdPath;

    /** 期望发送时间：0:立即发送 定时任务以及周期任务:cron表达式 */
    private String expectPushTime;

    /** 消息的发送ID类型：10. userId 20.did 30.手机号 40.openId 50.email 60.企业微信userId */
    private Byte idType;

    /** 消息发送渠道：10.IM 20.Push 30.短信 40.Email 50.公众号 60.小程序 70.企业微信 80.钉钉机器人 90.钉钉工作通知 100.企业微信机器人 110.飞书机器人 110. 飞书应用消息  */
    private Integer sendChannel;

    /** 10.运营类 20.技术类接口调用 */
    private Byte templateType;

    /** 10.通知类消息 20.营销类消息 30.验证码类消息 */
    private Byte msgType;

    /** 10.夜间不屏蔽 20.夜间屏蔽 30.夜间屏蔽(次日早上9点发送) */
    private Byte shieldType;

    /** 消息内容 占位符用{$var}表示 */
    private String msgContent;

    /** 发送账号 一个渠道下可存在多个账号 */
    private Integer sendAccount;

    /** 创建者 */
    private String creator;

    /** 更新者 */
    private String updator;

    /** 审核人 */
    private String auditor;

    /** 业务方团队 */
    private String team;

    /** 业务方 */
    private String proposer;

    /** 是否删除：0.不删除 1.删除 */
    private Byte isDeleted;

    /** 创建时间 */
    private Integer created;

    /** 更新时间 */
    private Integer updated;

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

    public Byte getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getFlowId() {
        return flowId;
    }

    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }

    public Byte getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Byte msgStatus) {
        this.msgStatus = msgStatus;
    }

    public Long getCronTaskId() {
        return cronTaskId;
    }

    public void setCronTaskId(Long cronTaskId) {
        this.cronTaskId = cronTaskId;
    }

    public String getCronCrowdPath() {
        return cronCrowdPath;
    }

    public void setCronCrowdPath(String cronCrowdPath) {
        this.cronCrowdPath = cronCrowdPath;
    }

    public String getExpectPushTime() {
        return expectPushTime;
    }

    public void setExpectPushTime(String expectPushTime) {
        this.expectPushTime = expectPushTime;
    }

    public Byte getIdType() {
        return idType;
    }

    public void setIdType(Byte idType) {
        this.idType = idType;
    }

    public Integer getSendChannel() {
        return sendChannel;
    }

    public void setSendChannel(Integer sendChannel) {
        this.sendChannel = sendChannel;
    }

    public Byte getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Byte templateType) {
        this.templateType = templateType;
    }

    public Byte getMsgType() {
        return msgType;
    }

    public void setMsgType(Byte msgType) {
        this.msgType = msgType;
    }

    public Byte getShieldType() {
        return shieldType;
    }

    public void setShieldType(Byte shieldType) {
        this.shieldType = shieldType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public Integer getSendAccount() {
        return sendAccount;
    }

    public void setSendAccount(Integer sendAccount) {
        this.sendAccount = sendAccount;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", auditStatus=").append(auditStatus);
        sb.append(", flowId=").append(flowId);
        sb.append(", msgStatus=").append(msgStatus);
        sb.append(", cronTaskId=").append(cronTaskId);
        sb.append(", cronCrowdPath=").append(cronCrowdPath);
        sb.append(", expectPushTime=").append(expectPushTime);
        sb.append(", idType=").append(idType);
        sb.append(", sendChannel=").append(sendChannel);
        sb.append(", templateType=").append(templateType);
        sb.append(", msgType=").append(msgType);
        sb.append(", shieldType=").append(shieldType);
        sb.append(", msgContent=").append(msgContent);
        sb.append(", sendAccount=").append(sendAccount);
        sb.append(", creator=").append(creator);
        sb.append(", updator=").append(updator);
        sb.append(", auditor=").append(auditor);
        sb.append(", team=").append(team);
        sb.append(", proposer=").append(proposer);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}