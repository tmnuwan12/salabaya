package com.nu.tools.loaders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.nu.tools.models.Command;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @author Thusitha Nuwan
 */
public class YmlLoader {


    public Command.Commands load(){

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        Command.Commands commands = null;
        try {
            InputStream input = this.getClass().getResourceAsStream("/commands.yml");
            commands = mapper.readValue(input, Command.Commands.class);



            return commands;
        } catch (IOException e) {
            e.printStackTrace();
        }

    return commands;
    }


}
