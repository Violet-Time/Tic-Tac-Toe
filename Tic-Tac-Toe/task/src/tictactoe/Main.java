package tictactoe;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tictactoe tictactoe = new Tictactoe();
        //System.out.print("Enter cells: ");
        //tictactoe.game(scanner.nextLine());
        System.out.println(tictactoe);
        while (tictactoe.state()) {
            System.out.print("Enter the coordinates: ");
            try {
                int[] x = Arrays.stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                if (x[0] > 0 && x[0] < 4 && x[1] > 0 && x[1] < 4 ) {
                    tictactoe.nextStep(x[0], x[1]);
                    System.out.println(tictactoe);
                } else {
                    System.out.println("Coordinates should be from 1 to 3!\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }

    }
}
