import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[][] gameBoard = {{"     ",  "  |  ",  "     ",  "  |  ",  "     ",  "  |  ",  "     "},
            {"  -  ",  "  +  ",  "  -  ",  "  +  ",  "  -  ",  "  +  ",  "  -  "},
            {"     ",  "  |  ",  "     ",  "  |  ",  "     ",  "  |  ",  "     "},
            {"  -  ",  "  +  ",  "  -  ",  "  +  ",  "  -  ",  "  +  ",  "  -  "},
            {"     ",  "  |  ",  "     ",  "  |  ",  "     ",  "  |  ",  "     "},
            {"  -  ",  "  +  ",  "  -  ",  "  +  ",  "  -  ",  "  +  ",  "  -  "},
            {"     ",  "  |  ",  "     ",  "  |  ",  "     ",  "  |  ",  "     "},};
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        generateRandomNumber();
        printGameBoard();

        while(true) {
            System.out.println("Choose what to do(r, l, u, d):");
            String action = scanner.nextLine();
            if(!action.equals("r") && !action.equals("l") && !action.equals("u") &&!action.equals("d")) continue;
            makeMovement(action);
            generateRandomNumber();
            printGameBoard();
        }
    }

    public static void printGameBoard() {
        for ( String[] row : gameBoard){
            for (String l : row){
                System.out.print(l);
            }
            System.out.println();
        }
    }

    public static void generateRandomNumber() {
        Random random = new Random();
//        int number = random.nextInt(16) + 1;
        int number = 4;
        int value = 0;
        if(random.nextInt(3) == 0){
            value = 4;
        } else {
            value = 2;
        }

        switch (number){
            case 1:
                gameBoard[0][0] = String.format("%5s", String.valueOf(value));
                break;
            case 2:
                gameBoard[0][2] = String.format("%5s", String.valueOf(value));
                break;
            case 3:
                gameBoard[0][4] = String.format("%5s", String.valueOf(value));
                break;
            case 4:
                gameBoard[0][6] = String.format("%5s", String.valueOf(value));
                break;
            case 5:
                gameBoard[2][0] = String.format("%5s", String.valueOf(value));
                break;
            case 6:
                gameBoard[2][2] = String.format("%5s", String.valueOf(value));
                break;
            case 7:
                gameBoard[2][4] = String.format("%5s", String.valueOf(value));
                break;
            case 8:
                gameBoard[2][6] = String.format("%5s", String.valueOf(value));
                break;
            case 9:
                gameBoard[4][0] = String.format("%5s", String.valueOf(value));
                break;
            case 10:
                gameBoard[4][2] = String.format("%5s", String.valueOf(value));
                break;
            case 11:
                gameBoard[4][4] = String.format("%5s", String.valueOf(value));
                break;
            case 12:
                gameBoard[4][6] = String.format("%5s", String.valueOf(value));
                break;
            case 13:
                gameBoard[6][0] = String.format("%5s", String.valueOf(value));
                break;
            case 14:
                gameBoard[6][2] = String.format("%5s", String.valueOf(value));
                break;
            case 15:
                gameBoard[6][4] = String.format("%5s", String.valueOf(value));
                break;
            case 16:
                gameBoard[6][6] = String.format("%5s", String.valueOf(value));
                break;
            default:
                break;
        }
    }

    public static void makeMovement(String param) {
        String[][] savedGameBoard;
        switch (param){
            case "r" :
                do {
                    savedGameBoard = gameBoard;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (gameBoard[i * 2][6 - (j * 2)].isBlank()) {
                                gameBoard[i * 2][6 - (j * 2)] = gameBoard[i * 2][4 - (j * 2)];
                                gameBoard[i * 2][4 - (j * 2)] = String.format("%5s", "");
                            }
                        }
                    }
                } while (!Arrays.deepEquals(savedGameBoard, gameBoard));
                break;

            case "l" :
                while(true) {
                    savedGameBoard = gameBoard.clone();
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 3; j++) {
                            if (gameBoard[i * 2][j * 2].isBlank()) {
                                gameBoard[i * 2][j * 2] = gameBoard[i * 2][2 + (j * 2)];
                                gameBoard[i * 2][2 + (j * 2)] = String.format("%5s", "");
                            }
                        }
                    }
                    System.out.println(savedGameBoard);
                    System.out.println(gameBoard);
                    if(Arrays.equals(savedGameBoard,gameBoard)) break;
                }
                break;

            case "u" :
                do {
                    savedGameBoard = gameBoard;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (gameBoard[i * 2][j * 2].isBlank()) {
                                gameBoard[i * 2][j * 2] = gameBoard[2 + (i * 2)][j * 2];
                                gameBoard[2 + (i * 2)][j * 2] = String.format("%5s", "");
                            }
                        }
                    }
                } while (!Arrays.deepEquals(savedGameBoard, gameBoard));
                break;

            case "d" :
                do {
                    savedGameBoard = gameBoard;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 4; j++) {
                            if (gameBoard[6 - (i * 2)][j * 2].isBlank()) {
                                gameBoard[6 - (i * 2)][j * 2] = gameBoard[4 - (i * 2)][j * 2];
                                gameBoard[4 - (i * 2)][j * 2] = String.format("%5s", " ");
                            }
                        }
                    }
                } while (!Arrays.deepEquals(savedGameBoard, gameBoard));
                break;

        }
    }

    // check static()

    //merge numbers()

    //check Lose()

    //print result()
}