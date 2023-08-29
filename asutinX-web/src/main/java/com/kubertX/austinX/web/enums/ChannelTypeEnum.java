package com.kubertX.austinX.web.enums;


public enum ChannelTypeEnum {


    EMAIL(40,"邮件"),

    ;

    ChannelTypeEnum(Integer codeType,String codeDesc){
        this.codeType = codeType;
        this.codeDesc = codeDesc;
    }
    /**
     * 渠道编码
     */
    private Integer codeType;

    /**
     * 渠道编码描述
     */
    private String codeDesc;

    public Integer getCodeType() {
        return codeType;
    }

    public void setCodeType(Integer codeType) {
        this.codeType = codeType;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }
}
