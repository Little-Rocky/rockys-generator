package com.gen.generator;

import com.gen.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

import static com.gen.generator.DynamicGenerator.doGenerate;
import static com.gen.generator.StaticGenerator.copyFilesByTools;

/**
 * 静态和动态代码生成
 * @author Rocky
 */
public class MainGenerator {

    public static void main(String[] args) throws TemplateException, IOException {
        // 静态代码生成
        String projectPath = System.getProperty("user.dir");
        // 输入路径
        String inputPath = projectPath + File.separator + "testCopy" + File.separator + "acm-template";
        // 输出路径
        String outPath = projectPath;
        // 复制
        copyFilesByTools(inputPath, outPath);

        // 动态代码生成
        String dynamicInputPath = projectPath + File.separator + "rockys-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";

        // 数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Rocky");
        mainTemplateConfig.setOutputText("输出结果：");
        mainTemplateConfig.setLoop(true);

        doGenerate(dynamicInputPath, dynamicOutputPath, mainTemplateConfig);
    }

}
