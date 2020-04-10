package domain;

import java.util.Arrays;

public enum Command {
    ORDER("1"),
    PAY("2"),
    EXIT("3");

    private final String commandSignal;

    Command(String commandSignal) {
        this.commandSignal = commandSignal;
    }

    public static void of(String command) {
        validate(command);
    }

    private static void validate(String command) {
        Arrays.stream(values())
                .filter(cmd -> cmd.commandSignal.equals(command))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 명령어입니다."));
    }
}
