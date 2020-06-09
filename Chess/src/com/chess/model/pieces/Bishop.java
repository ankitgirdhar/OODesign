package com.chess.model.pieces;

import com.chess.model.ColorType;

public class Bishop extends Piece {
    public Bishop(ColorType colorType, int currentX, int currentY) {
        super(colorType, currentX, currentY, PieceType.BISHOP);
    }

    @Override
    public boolean canMove(int finalX, int finalY) {
        if(Math.abs(finalX - getCurrentX()) == Math.abs(finalY - getCurrentY()))
            return true;
        return false;
    }
}
