public class Pawn extends ChessPiece{

    public Pawn(String color) {
        super(color);
    }

    public String getColor(){
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if ((0 <= line && line <= 7) && (0 <= column && column <= 7) && (0 <= toLine && toLine <= 7) && (0 <= toColumn && toColumn <= 7)){
            if (chessBoard.board[line][column].equals(this)){
                if (chessBoard.board[toLine][toColumn] == null){
                    if (column == toColumn) {
                        if (color.equals("White")) {
                            if (line == 1) {
                                if ((toLine - line == 2) || (toLine - line == 1)) return true;
                                else return false;
                            } else if (toLine - line == 1) return true;
                            else return false;
                        } else if (color.equals("Black")) {
                            if (line == 6) {
                                if ((line - toLine == 2) || (line - toLine == 1)) return true;
                                else return false;
                            } else if (line - toLine == 1) return true;
                            else return false;
                        } else return false;
                    }  else return false;
                } else if (!chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                    if (color.equals("Black")) {
                        if ((line - toLine == 1) && (Math.abs(column - toColumn) == 1)) return true;
                        else return false;
                    } else if ((toLine - line == 1) && (Math.abs(column - toColumn) == 1)) return true;
                    else return false;
                } else return false;
            }else return false;
        } else return false;
    }

    public String getSymbol(){
        return "P";
    }
}