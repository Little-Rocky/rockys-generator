package com.gen.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {

    public static void main(String[] args) {
        // 获取文件路径
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        // 输入路径
        String inputPath = projectPath + File.separator + "testCopy" + File.separator + "acm-template";
        // 输出路径
        String outPath = projectPath;
        // 复制
        copyFilesByTools(inputPath, outPath);
    }

    /**
     * 调用 hutool 方法类拷贝文件
     *
     * @param inputPath
     * @param outPath
     */
    public static void copyFilesByTools(String inputPath, String outPath) {
        FileUtil.copy(inputPath, outPath, true);
    }
}
