package com.gen.cli.pattern;

import com.gen.cli.example.RemoteControl;

public class Client {
    public static void main(String[] args) {
        // 创建接收者对象 （先有设备）
        Device tv = new Device("TV");
        Device stereo = new Device("stereo");

        // 创建具体命令对象，可以绑定不同的设备 
        TurnOnCommand turnOn = new TurnOnCommand(tv);
        TurnOffCommand turnOff = new TurnOffCommand(stereo);

        // 创建调用者 （弄一个遥控器）
        RemoteControl remote = new RemoteControl();

        // 执行命令 （把打开设备的按钮装在遥控器上）
        remote.setCommand(turnOn);
        remote.pressButton();

        // （把关闭设备的按钮装在遥控器上）
        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
