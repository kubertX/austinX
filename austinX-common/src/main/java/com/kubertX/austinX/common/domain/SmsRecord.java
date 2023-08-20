package com.kubertX.austinX.common.domain;

import java.io.Serializable;

public class SmsRecord implements Serializable {
    private Long id;

    /** 消息模板ID */
    private Long messageTemplateId;

    /** 手机号 */
    private Long phone;

    /** 发送短信渠道商的ID */
    private Byte supplierId;

    /** 发送短信渠道商的名称 */
    private String supplierName;

    /** 短信发送的内容 */
    private String msgContent;

    /** 下发批次的ID */
    private String seriesId;

    /** 计费条数 */
    private Byte chargingNum;

    /** 回执内容 */
    private String reportContent;

    /** 短信状态： 10.发送 20.成功 30.失败 */
    private Byte status;

    /** 发送日期：20211112 */
    private Integer sendDate;

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

    public Long getMessageTemplateId() {
        return messageTemplateId;
    }

    public void setMessageTemplateId(Long messageTemplateId) {
        this.messageTemplateId = messageTemplateId;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Byte getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Byte supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public Byte getChargingNum() {
        return chargingNum;
    }

    public void setChargingNum(Byte chargingNum) {
        this.chargingNum = chargingNum;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getSendDate() {
        return sendDate;
    }

    public void setSendDate(Integer sendDate) {
        this.sendDate = sendDate;
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
        sb.append(", messageTemplateId=").append(messageTemplateId);
        sb.append(", phone=").append(phone);
        sb.append(", supplierId=").append(supplierId);
        sb.append(", supplierName=").append(supplierName);
        sb.append(", msgContent=").append(msgContent);
        sb.append(", seriesId=").append(seriesId);
        sb.append(", chargingNum=").append(chargingNum);
        sb.append(", reportContent=").append(reportContent);
        sb.append(", status=").append(status);
        sb.append(", sendDate=").append(sendDate);
        sb.append(", created=").append(created);
        sb.append(", updated=").append(updated);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}