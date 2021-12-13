package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2470_binary {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
    }

    static void solution() {
        Arrays.sort(arr);

        int max = Integer.MAX_VALUE;
        int lt = 0, rt = N - 1, num1 = 0, num2 = 0;

        while(lt < rt) {
            int sum = arr[lt] + arr[rt];

            if (Math.abs(sum) < max) {
                max = Math.abs(sum);
                num1 = arr[lt];
                num2 = arr[rt];
            }

            if (sum > 0) rt--;
            else lt++;
        }

        sb.append(num1).append(" ").append(num2);
        System.out.println(sb.toString());
    }
}
