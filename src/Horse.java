public class Horse extends ChessPiece{

    public Horse(String color) {
        super(color);
    }

    public String getColor(){
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn){
        if ((0 <= line && line <= 7) && (0 <= column && column <= 7) && (0 <= toLine && toLine <= 7) && (0 <= toColumn && toColumn <= 7)){
            if ((Math.abs(toLine-line) == 1 && Math.abs(toColumn-column) == 2) ||
                    (Math.abs(toLine-line) == 2 && Math.abs(toColumn-column) == 1)){
                if (chessBoard.board[line][column].equals(this) && (chessBoard.board[toLine][toColumn] == null ||
                        !chessBoard.board[toLine][toColumn].color.equals(this.color))) {
                    return true;
                }else return false;
            } else return false;
        } else return false;
    }

    public String getSymbol(){
        return "H";
    }
}