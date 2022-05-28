package com.splitwise.command;

import com.splitwise.exceptions.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    Map<String, Command> commandMap;
    public static CommandFactory INSTANCE = null;
    private CommandFactory() {
        commandMap = new HashMap<>();
        commandMap.put("add_user", new AddUserCommand());
        commandMap.put("add_expense", new AddExpenseCommand());
        commandMap.put("show", new ShowCommand());
    }

    public static synchronized CommandFactory getInstance() {
        if(INSTANCE==null)
            INSTANCE = new CommandFactory();
        return INSTANCE;
    }

    public void execute(String[] cmd) throws InvalidCommandFormatException, InvalidSplitTypeException, InvalidSplitsTotalException, InvalidExpenseTypeException, NoSuchUserException {
        if(!commandMap.containsKey(cmd[0]))
            throw new InvalidCommandFormatException("Unrecognised command");
        commandMap.get(cmd[0]).execute(cmd);
    }

}
