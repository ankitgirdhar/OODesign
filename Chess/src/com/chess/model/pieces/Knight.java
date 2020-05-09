package com.chess.model.pieces;

import com.chess.model.ColorType;

public class Knight extends Piece {
    public Knight(ColorType colorType, int currentX, int currentY) {
        super(colorType, currentX, currentY, PieceType.KNIGHT);
    }

    @Override
    public boolean canMove(int finalX, int finalY) {
        if((Math.abs(finalX - getCurrentX()) == 2 && Math.abs(finalY - getCurrentY()) == 1) || (Math.abs(finalX - getCurrentX()) == 1 && Math.abs(finalY - getCurrentY()) == 2))
            return true;
        return false;
    }
}
