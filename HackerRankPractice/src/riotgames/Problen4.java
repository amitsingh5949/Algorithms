package riotgames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problen4 {

    static Character[][] layout;
    static List<String> comps = new ArrayList<>();

    public static void PrintGardenLayout() {
    	comps.clear();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] numsCount = bufferedReader.readLine().trim().split(",");
            int n = Integer.parseInt(numsCount[0]);
            int m = Integer.parseInt(numsCount[1]);
            layout = new Character[n][m];
            for (int x = 0; x < layout.length; x++)
                Arrays.fill(layout[x], 'B');

            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                String[] lineSplit = line.split(",");
                Character first = lineSplit[0].charAt(0);
                if (first.equals('C') || first.equals('D') || first.equals('F') || first.equals('E')) {
                    int second = Integer.parseInt(lineSplit[1]);
                    int third = Integer.parseInt(lineSplit[2]);
                    layout[third][second] = first;
                } else comps.add(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }


    public static boolean IsPlanValid() {
        PrintGardenLayout();
        Stack<Character> stack = new Stack<>();

        boolean res = true;

        for (String comp : comps) {

            String[] arr = comp.split(",");
            String action = arr[0];
            char type = arr[1].charAt(0);
            int x = Integer.parseInt(arr[2]);
            int y = Integer.parseInt(arr[3]);

            if (action.contains("Pick")) {
                if (layout[y][x] == 'B' || layout[y][x] != type) {
                	System.out.println(false);
                    printGrid(layout);
                    return false;
                } else {
                    stack.add(type);
                    layout[y][x] = 'B';
                }
            } else {
                if (stack.isEmpty() || stack.peek() != type || layout[y][x] != 'B') {
                	System.out.println(false);
                    printGrid(layout);
                    return false;
                } else {
                    layout[y][x] = stack.pop();
                }
            }

        }
        if (!stack.isEmpty()) {
            printGrid(layout);
            System.out.println(false);
            return false;
        }
        System.out.println(true);
        return res;

    }


    private static void printGrid(Character[][] matrix) {
        for (int x = 0; x < matrix[0].length; x++) {
            String res = "";
            for (int y = 0; y < matrix.length; y++) {
                res += matrix[x][y];
            }
            System.out.println(res);
        }
    }
}
