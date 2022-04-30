public class Chess {
    public static void main(String[] args) {

        String[][] chessBoard = new String[8][8];
        int letter = 65;
        int number = 8;

        for (int i = 0; i < chessBoard.length; i++) {

            for (int j = 0; j < chessBoard.length; j++) {
                chessBoard[i][j] = Character.toString(letter).toLowerCase().concat(Integer.toString(number));
                letter++;
            }
            letter = 65;
            number--;
        }
        System.out.println(knight("a1", "b2"));
    }

    public static int knight(String start, String  finish) {
        // Your code here!


        return -1;
    }

    public static int[][] basicMove() {

        int[][] board = {{1, 2}, {2, 3}};

        return board;

    }
}