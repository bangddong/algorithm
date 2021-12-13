package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_3273_binary {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, X;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        X = Integer.parseInt(br.readLine());
        solution();
    }

    static void solution() {
        Arrays.sort(arr);
        int lt = 0, rt = N - 1, answer = 0;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum == X) {
                answer++;
                lt++;
            } else if(sum > X) {
                rt--;
            } else {
                lt++;
            }
        }
        System.out.println(answer);
    }
}
