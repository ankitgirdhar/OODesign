package com.chess.model;

import java.net.URL;

public class Player extends Account{

    private URL picUrl;
    private String avatarName;
    private GameStats gameStats;
    private ColorType colorType;

    public Player(String userName, String email, String saltedHashPassword, ColorType colorType) {
        super(userName, email, saltedHashPassword);
        setColorType(colorType);
    }

    public URL getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(URL picUrl) {
        this.picUrl = picUrl;
    }

    public String getAvatarName() {
        return avatarName;
    }

    public void setAvatarName(String avatarName) {
        this.avatarName = avatarName;
    }

    public GameStats getGameStats() {
        return gameStats;
    }

    public void setGameStats(GameStats gameStats) {
        this.gameStats = gameStats;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }
}
