package com.chess.model.pieces;

import com.chess.model.ColorType;

public class Rook extends Piece {
    public Rook(ColorType colorType, int currentX, int currentY) {
        super(colorType, currentX, currentY, PieceType.ROOK);
    }

    @Override
    public boolean canMove(int finalX, int finalY) {
        if((finalX == getCurrentX()) || (finalY == getCurrentY()))
            return true;
        return false;
    }
}
