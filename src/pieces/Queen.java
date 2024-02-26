package pieces;

import main.Board;

import java.awt.image.BufferedImage;

public class Queen extends Piece{
    public Queen(Board board, int col, int row, boolean isWhite) {
        super(board);
        this.col = col;
        this.row = row;
        this.xPos = col * board.tileSize;
        this.yPos = row * board.tileSize;

        this.isWhite = isWhite;
        this.name = "Queen";

        this.sprite = sheet.getSubimage(sheetScale, isWhite? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);

    }
    public boolean isValidMovement(int col, int row) {
        return Math.abs(col - this.col) == Math.abs(row - this.row) || this.col == col || this.row == row;
    }
    @Override
    public boolean moveCollidesWithPiece(int col, int row) {
        if (this.col == col || this.row == row){
            //left
            if (this.col > col){
                for (int c = this.col - 1; c > col; c--){
                    if (board.getPiece(c, this.row) != null){
                        return true;
                    }
                }
            }
            //right
            if (this.col < col){
                for (int c = this.col + 1; c < col; c++){
                    if (board.getPiece(c, this.row) != null){
                        return true;
                    }
                }
            }
            //down
            if (this.row < row){
                for (int r = this.row + 1; r < row; r++){
                    if (board.getPiece(this.col, r) != null){
                        return true;
                    }
                }
            }
            //up
            if (this.row > row){
                for (int r = this.row - 1; r > row; r--){
                    if (board.getPiece(this.col, r) != null){
                        return true;
                    }
                }
            }
        } else {
            //left-up
            if (this.col > col && this.row > row){
                for (int i = 1; i < Math.abs(this.col - col); i++){
                    if (board.getPiece(this.col - i, this.row - i) != null){
                        return true;
                    }
                }
            }
            //right-up
            if (this.col < col && this.row > row){
                for (int i = 1; i < Math.abs(this.col - col); i++){
                    if (board.getPiece(this.col + i, this.row - i) != null){
                        return true;
                    }
                }
            }
            //left-down
            if (this.col > col && this.row < row){
                for (int i = 1; i < Math.abs(this.col - col); i++){
                    if (board.getPiece(this.col - i, this.row + i) != null){
                        return true;
                    }
                }
            }
            //right-down
            if (this.col < col && this.row < row){
                for (int i = 1; i < Math.abs(this.col - col); i++){
                    if (board.getPiece(this.col + i, this.row + i) != null){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
