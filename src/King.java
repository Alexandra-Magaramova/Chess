public class King extends ChessPiece {

    public King(String color) {
        super(color);
    }

    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if ((0 <= line && line <= 7) && (0 <= column && column <= 7) && (0 <= toLine && toLine <= 7) && (0 <= toColumn && toColumn <= 7)) {
            if (((Math.abs(toLine - line) == 1) && (Math.abs(toColumn - column) == 1)) ||
                    ((line == toLine) && (Math.abs(toColumn - column) == 1)) ||
                    ((column == toColumn) && (Math.abs(toLine - line) == 1))) {
                if (!isUnderAttack(chessBoard, toLine, toColumn)){
                    if (chessBoard.board[line][column].equals(this) && (chessBoard.board[toLine][toColumn] == null ||
                            !chessBoard.board[toLine][toColumn].color.equals(this.color))) {
                        return true;
                    } else return false;
                } else return false;
            } else return false;
        }else return false;
    }

    public String getSymbol() {
        return "K";
    }

    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        if ((0 <= line && line <= 7) && (0 <= column && column <= 7)) {
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    if ((chessBoard.board[i][j] != null) && (!chessBoard.board[i][j].getColor().equals(color) && chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column))) {
                        return true;
                    }
                }
            }
            return false;
        } else return false;
    }
}