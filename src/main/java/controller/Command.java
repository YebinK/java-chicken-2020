package controller;

import java.util.Arrays;

public enum Command {
    ORDER(1),
    PAY(2),
    EXIT(3);

    private final int commandSignal;

    Command(int commandSignal) {
        this.commandSignal = commandSignal;
    }

    public static Command of(int command) {
        return Arrays.stream(values())
                .filter(cmd -> cmd.commandSignal == command)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 명령어입니다."));
    }
}
