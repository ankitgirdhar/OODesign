package com.parking.models.electronics;

import com.parking.models.parking.interfaces.HasDisplay;

public class DisplayBoard extends Electronics implements HasDisplay {

    @Override
    public void showDisplay(String message) {
        System.out.println(message);
    }
}
