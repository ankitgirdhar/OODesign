package com.chess.model.pieces;

import com.chess.model.Auditable;
import com.chess.model.ColorType;

public abstract class Piece extends Auditable {
    private ColorType colorType;
    private int currentX;
    private int currentY;
    private boolean isKilled;
    private final PieceType type;

    public Piece(ColorType colorType, int currentX, int currentY, PieceType type) {
        this.colorType = colorType;
        this.currentX = currentX;
        this.currentY = currentY;
        this.type = type;
    }

    public abstract boolean canMove(int finalX,int finalY);

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void setCurrentX(int currentX) {
        this.currentX = currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public PieceType getType() {
        return type;
    }
}
