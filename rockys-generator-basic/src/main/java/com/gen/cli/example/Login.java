package com.gen.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;


class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @Option(names = {"-p", "--password"}, arity = "0..1", description = "Passphrase", interactive = true)
    String password;

    @Option(names = {"-cp", "--checkPassword"}, description = "check password", interactive = true)
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("user = " + user);
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        args = new String[]{"-u", "user123"};
        args = new String[]{"-u", "user123", "-p"};
        new CommandLine(new Login()).execute(args);
//        new CommandLine(new Login()).execute("-u", "user123");
    }
}