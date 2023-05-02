package com.lagou.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author xiaoyang
 * @date 2023/4/25
 * @program lagou_edu_home_parent
 */
@Getter
@Setter
public class ResponseResult {
    private Boolean success;
    private Integer state;
    private String message;
    private Object content;

    public ResponseResult() {
    }

    public ResponseResult(Boolean success, Integer state, String message, Object content) {
        this.success = success;
        this.state = state;
        this.message = message;
        this.content = content;
    }
}
