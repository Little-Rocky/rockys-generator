package com.gen.maker.model;

import lombok.Data;

@Data
public class DataModel {

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
