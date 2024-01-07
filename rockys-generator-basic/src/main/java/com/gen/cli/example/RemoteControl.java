package com.gen.cli.example;

import com.gen.cli.pattern.Command;

public class RemoteControl {

    private Command command;

    // 历史记录操作类似于
//    private List<Command> historyCommands;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        // 历史记录添加
//        historyCommands.add(command);
        command.execute();
    }
}
