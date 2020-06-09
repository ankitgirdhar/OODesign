package com.chess.model.pieces;

import com.chess.model.ColorType;
import com.chess.model.game.Board;

public class Pawn extends Piece {
    public Pawn(ColorType colorType, int currentX, int currentY) {
        super(colorType, currentX, currentY, PieceType.PAWN);
    }

    @Override
    public boolean canMove(int finalX, int finalY) {
        Board board = Board.getInstance();
        int xMove = (getColorType() == ColorType.BLACK) ? 1 : -1;

            if((board.getPieceAtBlock(getCurrentX()+xMove,getCurrentY()+1) != null) && (board.getPieceAtBlock(getCurrentX()+xMove,getCurrentY()-1) != null)) {
                if((finalX == getCurrentX()+xMove && finalY == getCurrentY()+1) || (finalX == getCurrentX()+xMove  && finalY == getCurrentY() - 1))
                    return true;
                return false;
            }
            if((board.getPieceAtBlock(getCurrentX()+xMove,getCurrentY()+1) != null)) {
                if((finalX == getCurrentX()+xMove && finalY == getCurrentY()+1))
                    return true;
                return false;
            }

            if((board.getPieceAtBlock(getCurrentX()+xMove,getCurrentY()-1) != null)) {
                if((finalX == getCurrentX()+xMove  && finalY == getCurrentY() - 1))
                    return true;
                return false;
            }
            if((board.getPieceAtBlock(getCurrentX()+xMove,getCurrentY()) != null))
                return false;
            if(finalX != getCurrentX()+xMove || finalY != getCurrentY())
                return false;
            return true;

        }

}
