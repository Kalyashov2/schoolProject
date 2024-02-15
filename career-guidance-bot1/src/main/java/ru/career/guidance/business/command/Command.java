package ru.career.guidance.business.command;

public enum Command {

    START("/start"),
    INFO("/info"),
    UNKNOWN("");

    private final String commandRaw;

    Command(String commandRaw) {
        this.commandRaw = commandRaw;
    }

    public static Command fromValue(String commandRaw) {
        for (Command command: values()) {
            if (commandRaw.contains(command.commandRaw)) {
                return command;
            }
        }

        return UNKNOWN;
    }
}