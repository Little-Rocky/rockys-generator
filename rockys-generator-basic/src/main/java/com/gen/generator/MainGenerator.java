package com.gen.generator;

import com.gen.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * 静态和动态代码生成
 *
 * @author Rocky
 */
public class MainGenerator {

    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        // 整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String inputPath = new File(parentFile, "rockys-generator/acm-template").getAbsolutePath();
        // 输出路径
        String outputPath = projectPath;
        // 复制
        StaticGenerator.copyFilesByTools(inputPath, outputPath);
        // 动态代码生成
        String dynamicInputPath = projectPath + File.separator + "rockys-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String dynamicOutputPath = projectPath + File.separator + "acm-template/src/com/yupi/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(dynamicInputPath, dynamicOutputPath, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("rocky");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }

}
