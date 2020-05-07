package com.splitwise;

import com.splitwise.exceptions.NoSuchUserException;
import com.splitwise.models.User;

public class Utils {

    public static boolean isApproxEqual(double sum, double totalAmount) {
        return (Math.abs(sum - totalAmount) / Math.min(Math.abs(sum), Math.abs(totalAmount))) < 1e-10;
    }

    public static double roundOff(double v) {
        return ((long) v * 100) / 100.0d;
    }

    public static User getUser(String cmd) throws NoSuchUserException {
        BookKeeper bk = BookKeeper.getInstance();
        User user;
        try {
            Long userId = Long.parseLong(cmd);
            user = bk.getUser(userId);
        } catch (NumberFormatException e) {
            String userEmail = cmd.strip();
            user = bk.getUser(userEmail);
        }
        return user;
    }
}
