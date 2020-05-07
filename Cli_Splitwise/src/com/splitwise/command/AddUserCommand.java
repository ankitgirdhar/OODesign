package com.splitwise.command;

import com.splitwise.BookKeeper;
import com.splitwise.models.User;

public class AddUserCommand implements Command {
    @Override
    public void execute(String[] cmd) {
        BookKeeper bk = BookKeeper.getInstance();
        bk.addUser(new User(cmd[1] , cmd[2] , cmd[3] ));
        System.out.println("User added!!");
    }
}

// add_user name email password


