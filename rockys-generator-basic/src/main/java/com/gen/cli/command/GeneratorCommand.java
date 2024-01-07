package com.gen.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.gen.generator.MainGenerator;
import com.gen.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * @author Rocky
 */
@CommandLine.Command(name = "generator", mixinStandardHelpOptions = true)
@Data
public class GeneratorCommand implements Callable {

    /**
     * 作者
     */
    @CommandLine.Option(names = {"-a"}, description = "作者名称", arity = "0..1", interactive = true)
    private String author = "rocky";

    /**
     * 输出信息
     */
    @CommandLine.Option(names = {"-o"}, description = "输出信息", arity = "0..1", interactive = true)
    private String outputText = "sum";

    /**
     * 是否循环
     */
    @CommandLine.Option(names = {"-l"}, description = "是否循环", arity = "0..1", interactive = true)
    private boolean loop;

    @Override
    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        MainGenerator.doGenerate(mainTemplateConfig);
        return 0;
    }
}
