package com.gen.model;

import lombok.Data;

@Data
public class MainTemplateConfig {

    /**
     * 作者
     */
    private String author;

    /**
     * 输出信息
     */
    private String outputText;

    /**
     * 是否循环
     */
    private boolean loop;
}
