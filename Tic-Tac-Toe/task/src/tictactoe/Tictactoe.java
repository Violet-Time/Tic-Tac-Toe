package tictactoe;

import java.util.Arrays;

public class Tictactoe {
    private char[][] gameField;

    public Tictactoe() {
        this(3,3);
    }

    public Tictactoe(int height, int weight) {
        this.gameField = new char[height][weight];
        for (char[] chars : gameField) {
            Arrays.fill(chars, '_');
        }
    }

    public void game(String enter) {
        int i = 0;
        for (int h = 0; h < gameField.length; h++) {
            for (int w = 0; w < gameField[h].length;) {
                if (enter.charAt(i) == 'X' || enter.charAt(i) == 'O' || enter.charAt(i) == '_') {
                    gameField[h][w] = (enter.charAt(i));
                    i++;
                    w++;
                }
            }
        }
    }

    public boolean state() {
        int scoreX = 0;
        int scoreO = 0;
        int emptyCells = 0;
        int countX = 0;
        int countO = 0;
        for (char[] chars : gameField) {
            for (char aChar : chars) {
                if (aChar == '_') {
                    emptyCells++;
                }
                if (aChar == 'O') {
                    countO++;
                }
                if (aChar == 'X') {
                    countX++;
                }
            }
            if (chars[0] == chars[1] && chars[1] == chars[2]) {
                if (chars[0] == 'O') {
                    scoreO++;
                } else if (chars[0] == 'X') {
                    scoreX++;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gameField[0][i] == gameField[1][i] && gameField[1][i] == gameField[2][i]) {
                if (gameField[0][i] == 'O') {
                    scoreO++;
                } else if (gameField[0][i] == 'X') {
                    scoreX++;
                }
            }
        }

        if (gameField[0][0] == gameField[1][1] && gameField[1][1] == gameField[2][2]) {
            if (gameField[1][1] == 'O') {
                scoreO++;
            } else if (gameField[1][1] == 'X') {
                scoreX++;
            }
        }

        if (gameField[2][0] == gameField[1][1] && gameField[1][1] == gameField[0][2]) {
            if (gameField[1][1] == 'O') {
                scoreO++;
            } else if (gameField[1][1] == 'X') {
                scoreX++;
            }
        }


        if (scoreO + scoreX > 1 || countX - countO > 1 || countO - countX > 1) {
            System.out.println("Impossible");
            return false;
        }

        if (scoreO > scoreX) {
            System.out.println("O wins");
            return false;
        }
        if (scoreO < scoreX) {
            System.out.println("X wins");
            return false;
        }
        if (emptyCells > 0) {
            //System.out.println("Game not finished");
            return true;
        }
        System.out.println("Draw");
        return false;
    }

    public boolean nextStep(int x, int y) {
        y = (y - 3) * -1;
        if (gameField[y][x - 1] == '_') {
            int countO = 0;
            int countX = 0;
            for (char[] chars : gameField) {
                for (char aChar : chars) {
                    if (aChar == 'O') {
                        countO++;
                    }
                    if (aChar == 'X') {
                        countX++;
                    }
                }
            }
            if (countX > countO) {
                gameField[y][x - 1] = 'O';
            } else {
                gameField[y][x - 1] = 'X';
            }
            return true;
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(45);
        builder.append("---------\n");
        for (char[] chars : gameField) {
            builder.append('|').append(' ');
            for (char aChar : chars) {
                builder.append(aChar).append(' ');
            }
            builder.append('|').append('\n');
        }
        builder.append("---------\n");
        return builder.toString();
    }
}
