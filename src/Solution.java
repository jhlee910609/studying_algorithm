package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

//1/31, 2/28, 3/31, 4/30, 5/31, 6/30, 7/31, 8/31, 9/30, 10/31, 11/30, 12/31

public class Solution {

    public static void main(String[] args) throws NumberFormatException, IOException {

        System.setIn(new FileInputStream("src/res/input.txt"));
        /*
         * 표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
         */
        Scanner sc = new Scanner(System.in);
        int T = 8;

        for (int testCase = 0; testCase < 10; testCase++) {
            int N = Integer.parseInt(sc.next());
            System.out.println(N);
            String[][] unit = new String[T][T];

            for (int i = 0; i < T; i++) {
                String tempStr = sc.nextLine();
                System.out.println(tempStr);
                String[] temp = tempStr.split("");

                for (int j = 0; j < T; j++) {
                    System.out.print(temp[j]);
                }
            }

            int result = 0;
            int row = 0;
            int col = 0;
            for (int i = 0; i < T; i++) {
                for (int k = 0; k <= T / 2; k++) {
                    if (unit[k][i].equals(unit[k + N - 1][i])) {
                        col++;
                    } else {
                        col = 0;
                    }

                    if (col == N / 2)
                        result++;

                }

                for (int j = 0; j <= T / 2; j++) {
                    if (unit[i][j].equals(unit[i][j + N - 1]))
                        row++;
                    else
                        row = 0;

                    if (row == T / 2) {
                        result++;
                    }
                }
            }

            System.out.printf("#%d %d", testCase + 1, result);
        }
        sc.close();
    }
}
