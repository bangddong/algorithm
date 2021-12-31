package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11726 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] A;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        A = new int[1001];

        A[1] = 1;
        A[2] = 2;
        for (int i = 3; i <= N; i++) A[i] = (A[i - 1] + A[i - 2]) % 10007;

        System.out.println(A[N]);
    }
}
