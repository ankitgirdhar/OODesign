package com.chess.model.pieces;

import com.chess.model.ColorType;

public class King extends Piece {

    public King(ColorType colorType, int currentX, int currentY) {
        super(colorType, currentX, currentY, PieceType.KING);
    }

    @Override
    public boolean canMove(int finalX, int finalY) {
        if(Math.abs(finalX - this.getCurrentX()) <=1 && Math.abs(finalY - this.getCurrentY()) <=1)
            return true;
        return false;
    }


}
