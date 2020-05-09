package com.chess.model.game;

import com.chess.exceptions.InvalidMoveException;
import com.chess.exceptions.InvalidPlayerException;
import com.chess.exceptions.NoPieceFoundException;
import com.chess.model.Auditable;
import com.chess.model.ColorType;
import com.chess.model.Player;
import com.chess.model.pieces.Piece;
import com.chess.model.pieces.PieceType;

public class Game extends Auditable {
    private Player p1;
    private Player p2;
    private Board board;
    private GameStatus gameStatus;
    private Player currentTurn;

    public Game() {
        p1 = null;
        p2 = null;
        currentTurn = null;
        this.board = Board.getInstance();
        this.gameStatus = GameStatus.PLAYING;
    }

    public void addFirstPlayer(String name,String email, String password) {
        p1 = new Player(name,email,password, ColorType.BLACK);
        currentTurn = p1;
        System.out.println("Player 1 added!!");
    }

    public void addSecondPlayer(String name,String email, String password) {
        p1 = new Player(name,email,password, ColorType.WHITE);
        System.out.println("Player 2 added!!");
    }

    public void makeMove(Piece piece, int x, int y) throws InvalidMoveException, NoPieceFoundException, InvalidPlayerException {
        if(currentTurn.getColorType() != piece.getColorType())
            throw new InvalidPlayerException("piece color and player color donot match!!");
        if(x<0 || y<0 || y>=8 || x>=8)
            throw new InvalidMoveException("move should be within the board!!");

        if(!piece.canMove(x,y))
            throw new InvalidMoveException("Move violates piece movement rules!!");

        if(board.getPieceAtBlock(x,y) != null) {
            if(board.getColorAtBlock(x,y) == currentTurn.getColorType())
                throw new InvalidMoveException("Cannot move at location where you have your own piece!!");
            else {
                Piece p = board.getPieceAtBlock(x,y);
                p.setKilled(true); p.setCurrentX(-1); p.setCurrentY(-1);
                if(p.getType() == PieceType.KING) {
                    System.out.println(currentTurn.getAvatarName() + " Has won the match!! Congrats!");
                    endGame();
                } else {
                    System.out.println(currentTurn.getAvatarName() + " killed the opponents piece!! Congrats!");
                }
            }
        }
        piece.setCurrentX(x);
        piece.setCurrentY(y);
        if(currentTurn.getColorType() == p1.getColorType())
            currentTurn = p2;
        else
            currentTurn = p1;
    }

    public void endGame() {
        gameStatus = GameStatus.END;
        System.out.println("Game Ended!!");
    }
}
