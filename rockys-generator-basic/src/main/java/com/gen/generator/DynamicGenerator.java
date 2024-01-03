package com.gen.generator;

import com.gen.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 动态代码生成器
 */
public class DynamicGenerator {

    public static void main(String[] args) throws IOException, TemplateException {
        String projectPath = System.getProperty("user.dir") + File.separator + "rockys-generator-basic";
        String inputPath = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputPath = projectPath + File.separator + "MainTemplate.java";

        // 数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("Rocky");
        mainTemplateConfig.setOutputText("输出结果：");
        mainTemplateConfig.setLoop(false);

        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    public static void doGenerate(String inputPath, String outPutPath, Object model) throws IOException, TemplateException {
        // new出Configuration对象，参数为FreeMarker版本号
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

        // 获取模板路径
        File templateDir = new File(inputPath).getParentFile();
        cfg.setDirectoryForTemplateLoading(templateDir);

        cfg.setDefaultEncoding("UTF-8");
        // 避免2,023 应该是2023
        cfg.setNumberFormat("0.######");

        // 创建模板对象（指定名称） 加载指定模板
        String templateName = new File(inputPath).getName();
        Template template = cfg.getTemplate(templateName);

        // 指定生成文件
        Writer out = new FileWriter(outPutPath);
        template.process(model, out);

        // 关闭流
        out.close();
    }
}
