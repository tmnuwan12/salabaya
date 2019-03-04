package com.nu.tools;

import com.nu.tools.models.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Thusitha Nuwan
 */
public class CommandRepo {


    private Map<String, Command> commandRepo = new HashMap<>();


    public CommandRepo(Map<String, Command> commands){
        this.commandRepo = commands;
    }

    public Map<String, Command> getCommandRepo() {
        return commandRepo;
    }






}
