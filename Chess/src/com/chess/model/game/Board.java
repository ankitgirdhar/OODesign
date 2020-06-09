package com.chess.model.game;

import com.chess.exceptions.NoPieceFoundException;
import com.chess.model.Auditable;
import com.chess.model.ColorType;
import com.chess.model.pieces.*;

import java.util.ArrayList;

public class Board extends Auditable {
    private ArrayList<ArrayList<Block>> board;
    private static Board BOARD_INSTANCE = null;
    private Board() {
        this.board = new ArrayList<>();
        for(int i=0;i<8;i++) {
            ArrayList<Block> temp = new ArrayList<>();
            for (int j = 0; j < 8; j++)
                temp.add(new Block(i, j, null));
            board.add(temp);
        }
        // setting ROOK
        board.get(0).get(0).setPiece(new Rook(ColorType.BLACK,0,0));
        board.get(7).get(0).setPiece(new Rook(ColorType.WHITE,7,0));
        board.get(0).get(7).setPiece(new Rook(ColorType.BLACK,0,7));
        board.get(7).get(7).setPiece(new Rook(ColorType.WHITE,7,7));

        // setting knight
        board.get(0).get(1).setPiece(new Knight(ColorType.BLACK,0,1));
        board.get(7).get(1).setPiece(new Knight(ColorType.WHITE,7,1));
        board.get(0).get(6).setPiece(new Knight(ColorType.BLACK,0,6));
        board.get(7).get(6).setPiece(new Knight(ColorType.WHITE,7,6));

        //setting bishop
        board.get(0).get(2).setPiece(new Bishop(ColorType.BLACK,0,2));
        board.get(7).get(2).setPiece(new Bishop(ColorType.WHITE,7,2));
        board.get(0).get(5).setPiece(new Bishop(ColorType.BLACK,0,5));
        board.get(7).get(5).setPiece(new Bishop(ColorType.WHITE,7,5));

        // setting queen
        board.get(0).get(3).setPiece(new Queen(ColorType.BLACK,0,3));
        board.get(7).get(3).setPiece(new Queen(ColorType.WHITE,7,3));

        //setting king
        board.get(0).get(4).setPiece(new King(ColorType.BLACK,0,4));
        board.get(7).get(4).setPiece(new King(ColorType.WHITE,7,4));

        //setting pawns
        for(int i=0;i<8;i++) {
            board.get(1).get(i).setPiece(new Pawn(ColorType.BLACK,1,i));
            board.get(6).get(i).setPiece(new Pawn(ColorType.WHITE,6,i));
        }

    }

    public static Board getInstance() {
        if(BOARD_INSTANCE == null)
            BOARD_INSTANCE = new Board();
        return BOARD_INSTANCE;
    }


    public Piece getPieceAtBlock(int x,int y) {
        return board.get(x).get(y).getPiece();
    }

    public ColorType getColorAtBlock(int x,int y) throws NoPieceFoundException {
        if(getPieceAtBlock(x,y) == null)
            throw new NoPieceFoundException("No piece found at the given location!!");
        return getPieceAtBlock(x,y).getColorType();
    }

    public ArrayList<ArrayList<Block>> getBoard() {
        return board;
    }

    public void setBoard(ArrayList<ArrayList<Block>> board) {
        this.board = board;
    }
}
