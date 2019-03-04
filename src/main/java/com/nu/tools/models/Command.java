package com.nu.tools.models;

/**
 * @author Thusitha Nuwan
 */
public class Command {

    private String command;
    private String alias;

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    private String args;
    private String tags;
    private String description;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public static class Commands{

        private String version;
        private Command[] commands;


        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public Command[] getCommands() {
            return commands;
        }

        public void setCommands(Command[] commands) {
            this.commands = commands;
        }
    }
}
