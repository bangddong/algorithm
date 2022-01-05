package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2011 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String str;
    static int N, MOD = 1000000;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        str = br.readLine();
        N = str.length();
        dy = new int[N + 1];
        str = " " + str;
        solution();
    }

    static void solution() {
        dy[0] = 1;
        for (int i = 1; i <= N; i++) {
            int tmp = str.charAt(i) - '0';
            if (tmp >= 1 && tmp <= 9) dy[i] = (dy[i] + dy[i - 1]) % MOD;
            if(i == 1) continue;
            if(str.charAt(i - 1) == '0') continue;
            tmp = (str.charAt(i - 1) - '0') * 10 + (str.charAt(i) - '0');
            if (tmp >= 10 && tmp <= 26) dy[i] += (dy[i] + dy[i - 2]) % MOD;
        }
        System.out.println(dy[N]);
    }
}
