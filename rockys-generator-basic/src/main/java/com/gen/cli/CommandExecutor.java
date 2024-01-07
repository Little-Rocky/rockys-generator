package com.gen.cli;

import com.gen.cli.command.ConfigCommand;
import com.gen.cli.command.GeneratorCommand;
import com.gen.cli.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "rockys", mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    // 因为每次都要初始化，直接用成代码块
    {
        commandLine = new CommandLine(this)
                .addSubcommand(new GeneratorCommand())
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new ListCommand());
    }

    @Override
    public void run() {
        // 不输入子命令时，给出友好提示
        System.out.println("请输入具体命令，或者输入 --help 查看命令提示");
    }

    /**
     * 执行命令
     */
    public Integer doExecute(String[] args) {
        return commandLine.execute(args);
    }
}
