
package Main.Parser;

import java.util.*;

import Main.Commands.*;
import Main.CommandsInterface.*;
import java.util.ArrayList;

/*
public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("> ");
        String inputLine = reader.nextLine();

        String word1 = null;
        String word2 = null;
        String word3 = null;

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
                if (tokenizer.hasNext()) {
                    word3 = tokenizer.next();
                }
            }
        }
        //If the first word is a command and word 3 is not null, execute this code. This is done first because if the statement below was used, it would not use the third argument
        if (commands.isCommand(word1) && word3 != null) {
            return new Command(word1, word2, word3);
        }
        else if (commands.isCommand(word1)) {
            return new Command(word1, word2);
        }

        else {
            return new Command(null, word2);
        }
    }

    public void showCommands() {
        commands.showAll();
    }
}*/

public class Parser  {
    private Scanner reader;
    private CommandWords commands;



    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);

    }

   public String showCommands() {
        return commands.showAll();
   }

    public Command getCommand() {
        ArrayList <String> parsedWords = new ArrayList();
        System.out.print("> ");
        String inputLine = reader.nextLine();

        parsedWords.clear();
        Scanner tokenizer = new Scanner(inputLine);

        while (tokenizer.hasNext()) {
            parsedWords.add(tokenizer.next());
        }

        if (parsedWords.isEmpty()) {
            return new Command(null);  // Null commandWord indicates no command entered
        }

        String mainCommand = parsedWords.get(0).toLowerCase().trim();
        System.out.println("DEBUG CMD = [" + mainCommand + "]");
        // It creates a sub list after index 0 and creates an array. java automatically sets the size of array when you type toArray(new String[0])

        String argString = "";
        if (parsedWords.size() > 1) {
            argString = String.join(" ", parsedWords.subList(1, parsedWords.size()));
        }

        //String[] args = parsedWords.subList(1, parsedWords.size()).toArray(new String[0]);

        if(commands.isCommand(mainCommand)) {
            return new Command(mainCommand, argString);
        } else {
            return new Command(null, argString);
        }
    }

    public Command getCommand(String inputLine) {
        ArrayList <String> parsedWords = new ArrayList();

        Scanner tokenizer = new Scanner(inputLine);

        while (tokenizer.hasNext()) {
            parsedWords.add(tokenizer.next());
        }

        if (parsedWords.isEmpty()) {
            return new Command(null);
        }
        String mainCommand = parsedWords.get(0).toLowerCase().trim();
        System.out.println("DEBUG CMD = [" + mainCommand + "]");
        // It creates a sub list after index 0 and creates an array. java automatically sets the size of array when you type toArray(new String[0])
        String[] args = parsedWords.subList(1, parsedWords.size())
                .toArray(new String[0]);
       /* String argString = "";
        if (parsedWords.size() > 1) {
            argString = String.join(" ", parsedWords.subList(1, parsedWords.size()));
        }*/
        //String[] args = parsedWords.subList(1, parsedWords.size()).toArray(new String[0]);

        if(commands.isCommand(mainCommand)) {
            return new Command(mainCommand, args);
        } else {
            return new Command(null, args);
        }


    }
}