import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Chess {
        static String[][] chessBoard = new String[8][8];
    public static void main(String[] args) {

        int letter = 65; //"A" in ASCII code
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

    public static int knight(String start, String finish) {
        // Your code here!
        String[] algebraicCoordinates = start.split("");
        int[] startingCoordinates = new int[2];
        char letter = 'a';
        int steps = 0;

        /*
         *The algebraic coordinates in the String[] form of "a1" or "d7" changed into
         *  "7,0" or "1,3" respectively in the two for-loops below
         */

        for (int i = 0; i < 8; i++) {
            if (String.valueOf(letter).equals(algebraicCoordinates[0])) {
                startingCoordinates[0] = i;
                break;
            }
            letter++;
        }

        for (int i = 0, j = 7; i < 8 && j >= 0; i++, j--) {
            if (algebraicCoordinates[1].equals(Integer.toString(i))) {
                startingCoordinates[1] = j;
            }
        }

        for (int i = 0; i < 9; i++) {
            try {
                if (basicMove(i, chessBoard, startingCoordinates) != chessBoard) {
                    steps++;
                }
            } catch (IndexOutOfBoundsException e) {
                continue;
            }
        }

        return start.equals(finish) ? 0 : steps;
    }

    public static int[][] basicMove(int moveNumber, String[][] chessBoard, int[] coordinates) {

        Movement step1 = (t, z) -> {
            coordinates[0] = coordinates[0] - t;
            coordinates[1] = coordinates[1] - z;
            return new int[][]{{coordinates[0], coordinates[1]}};
        };
        Movement step2 = (t, z) -> {
            coordinates[0] = coordinates[0] - t;
            coordinates[1] = coordinates[1] + z;
            return new int[][]{{coordinates[0], coordinates[1]}};
        };
        Movement step3 = (t, z) -> {
            coordinates[0] = coordinates[0] + t;
            coordinates[1] = coordinates[1] - z;
            return new int[][]{{coordinates[0], coordinates[1]}};
        };
        Movement step4 = (t, z) -> {
            coordinates[0] = coordinates[0] + t;
            coordinates[1] = coordinates[1] + z;
            return new int[][]{{coordinates[0], coordinates[1]}};
        };
        Movement step5 = (t, z) -> {
            coordinates[0] = coordinates[0] - t;
            coordinates[1] = coordinates[1] + z;
            return new int[][]{{coordinates[0], coordinates[1]}};
        };
        Movement step6 = (t, z) -> {
            coordinates[0] = coordinates[0] + t;
            coordinates[1] = coordinates[1] + z;
            return new int[][]{{coordinates[0], coordinates[1]}};
        };
        Movement step7 = (t, z) -> {
            coordinates[0] = coordinates[0] - t;
            coordinates[1] = coordinates[1] - z;
            return new int[][]{{coordinates[0], coordinates[1]}};
        };
        Movement step8 = (t, z) -> {
            coordinates[0] = coordinates[0] + t;
            coordinates[1] = coordinates[1] - z;
            return new int[][]{{coordinates[0], coordinates[1]}};
        };

        switch (moveNumber) {
                case 1: {
                   return step1.make(2, 1);
                }
                case 2: {
                    return step2.make(2, 1);
                }
                case 3: {
                    return step3.make(2, 1);
                }
                case 4: {
                    return step4.make(2, 1);
                }
                case 5: {
                    return step5.make(1, 2);
                }
                case 6: {
                    return step6.make(1, 2);
                }
                case 7: {
                    return step7.make(1, 2);
                }
                case 8: {
                    return step8.make(1, 2);
                }
        }
        return new int[0][0];
    }

    public ArrayList permuteMoves(int group, int index) {
        ArrayList<Integer> movesNumbers = new ArrayList<>();
        HashSet<String> permutations = new HashSet<>();

        for (int i = 1; i <= 8; i++) {
            movesNumbers.add(i);
        }

        do {
            Collections.shuffle(movesNumbers);
            permutations.add(String.valueOf(movesNumbers));
        } while (permutations.size() <= 40319);

        return new ArrayList<>(permutations);

//        return Character.getNumericValue(permutationsAsList.get(group).charAt(index));
    }

    public boolean isFinishReached() {

        return true;
    }
}