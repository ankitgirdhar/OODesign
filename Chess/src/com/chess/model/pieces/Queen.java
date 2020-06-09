package com.chess.model.pieces;

import com.chess.model.ColorType;

public class Queen extends Piece {
    public Queen(ColorType colorType, int currentX, int currentY) {
        super(colorType, currentX, currentY, PieceType.QUEEN);
    }

    @Override
    public boolean canMove(int finalX, int finalY) {
        if((finalX == getCurrentX()) || (finalY == getCurrentY()))
            return true;
        if(Math.abs(finalX - getCurrentX()) == Math.abs(finalY - getCurrentY()))
            return true;
        return false;
    }
}
