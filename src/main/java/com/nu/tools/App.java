package com.nu.tools;

import com.nu.tools.loaders.YmlLoader;
import com.nu.tools.models.Command;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {

        System.out.println("Salabaya is starting...");
        System.out.println("Loading commands from yml...");
        YmlLoader loader = new YmlLoader();

        Command.Commands commands = loader.load();

        Map<String, Command> indexedCommands = new HashMap<>();

        for(Command c : commands.getCommands()){

            indexedCommands.put(c.getAlias(), c);
        }



        CommandRepo repo = new CommandRepo(indexedCommands);


        while(true){
            System.out.println("Following are the available aliases..");

            System.out.println("-------------------------------------");
            Set<String> aliases = repo.getCommandRepo().keySet();

            TreeSet<String> orderedAliases = new TreeSet();
            orderedAliases.addAll(aliases);

            for(String alias: orderedAliases){
                System.out.println(alias + " | " + repo.getCommandRepo().get(alias).getDescription());
            }





            System.out.println("-------------------------------------");

            System.out.println("Please enter the alias to get the command");
            Scanner reader = new Scanner(System.in);

            String alias = reader.nextLine();

            Command c = repo.getCommandRepo().get(alias);

            String cmd = "n/a";
            if(c.getArgs() != null && !c.getArgs().isEmpty()){

                String[] cmdArgs = c.getArgs().split(",");
                for(String s: cmdArgs){
                    System.out.println("Please enter " + s);
                    String argValue = reader.nextLine();
                    if(cmd.equalsIgnoreCase("n/a")){
                        cmd = c.getCommand().replaceFirst(s, argValue);
                    }else{
                        cmd = cmd.replaceFirst(s, argValue);
                    }
                }
            }else{
                cmd = c.getCommand();
            }
            StringSelection selection = new StringSelection(cmd);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
            System.out.println("Command (copied to clipboard) ==> " + cmd);

            System.out.println("Do you want to continue (Y/N)?");

            String yesNo = reader.nextLine();

            if(yesNo.equalsIgnoreCase("y") ){
                continue;
            }else{
                break;
            }
           // reader.close();
        }


    }
}
