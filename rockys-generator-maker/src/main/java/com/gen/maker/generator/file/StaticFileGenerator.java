package com.gen.maker.generator.file;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticFileGenerator {

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
