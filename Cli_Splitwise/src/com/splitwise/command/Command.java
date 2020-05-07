package com.splitwise.command;

import com.splitwise.exceptions.InvalidExpenseTypeException;
import com.splitwise.exceptions.InvalidSplitTypeException;
import com.splitwise.exceptions.InvalidSplitsTotalException;
import com.splitwise.exceptions.NoSuchUserException;

public interface Command {
    void execute(String[] cmd) throws InvalidExpenseTypeException, InvalidSplitTypeException, InvalidSplitsTotalException, NoSuchUserException;
}
