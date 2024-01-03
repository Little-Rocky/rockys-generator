import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreemarkerTest {

    @Test
    public void test() throws IOException, TemplateException {
        // new出Configuration对象，参数为FreeMarker版本号
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

        // 指定模板文件所在的路径
        cfg.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        cfg.setDefaultEncoding("UTF-8");
        // 避免2,023 应该是2023
        cfg.setNumberFormat("0.######");

        // 创建模板对象 加载指定模板
        Template template = cfg.getTemplate("myweb.html.ftl");

        // 数据模型
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2023);
        List<Map<String, Object>> menuItems = new ArrayList<>();

        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "https://codefather.cn");
        menuItem1.put("label", "编程导航");

        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "https://laoyujianli.com");
        menuItem2.put("label", "老鱼简历");

        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems", menuItems);

        // 指定生成文件
        Writer out =  new FileWriter("myweb.html");
        template.process(dataModel, out);

        // 关闭流
        out.close();
    }
}
