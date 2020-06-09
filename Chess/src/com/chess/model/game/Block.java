package com.chess.model.game;

import com.chess.model.Auditable;
import com.chess.model.pieces.Piece;

public class Block extends Auditable {
    private int posX;
    private int posY;
    private Piece piece;

    public Block(int posX, int posY, Piece piece) {
        this.posX = posX;
        this.posY = posY;
        this.piece = piece;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
