package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3085 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n, result = 1;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 초기값 상태에서 연속되는 최대 카운트 구하기
        countContinue();
        // 하나씩 바꾸며 다시 카운트 해보기
        swapAndCountContinue();
        // 결과값 출력
        System.out.println(result);
    }

    public static void countContinue() {
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                    cnt++;
                    result = Math.max(cnt, result);
                } else {
                    cnt = 1;
                }
            }
            cnt = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    cnt++;
                    result = Math.max(cnt, result);
                } else {
                    cnt = 1;
                }
            }
            cnt = 1;
        }
    }

    public static void swapAndCountContinue() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[i][j] != board[i][j + 1]) {
                    char tmpX = board[i][j];
                    char tmpY = board[i][j + 1];
                    board[i][j] = tmpY;
                    board[i][j + 1] = tmpX;
                    countContinue();
                    board[i][j] = tmpX;
                    board[i][j + 1] = tmpY;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (board[j][i] != board[j + 1][i]) {
                    char tmpX = board[j][i];
                    char tmpY = board[j + 1][i];
                    board[j][i] = tmpY;
                    board[j + 1][i] = tmpX;
                    countContinue();
                    board[j][i] = tmpX;
                    board[j + 1][i] = tmpY;
                }
            }
        }
    }
}
