package org.opensdg.testapp;

public abstract class CommandHandler {
    public int numRequiredArgs() {
        return 0;
    }

    public abstract void Execute(String[] command);
}
