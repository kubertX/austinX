package com.kubertX.austinX.web.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class MessageTemplateVo {

    private List<Map<String,Object>> rows;

    private Long count;
}
