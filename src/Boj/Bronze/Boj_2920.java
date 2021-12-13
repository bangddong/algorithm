package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2920 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] arr;
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        arr = new int[8];
        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }
    // 1. 오름차순 = ascending
    // 2. 내림차순 = descending
    // 3. 혼합 = mixed
    static void solution() {
        String answer = "";
        for (int i = 0; i < 7; i++) {
            if (arr[i] - arr[i + 1] == 1) {
                answer = "descending";
            } else if (arr[i] - arr[i + 1] == -1) {
                answer = "ascending";
            } else {
                answer = "mixed";
                break;
            }
        }
        System.out.println(answer);
    }
}
