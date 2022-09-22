package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6064 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T;
    static int M, N, X, Y, lcm;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        while(T --> 0) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            lcm = M * N / gcd(M, N);
            incaCalendar();
        }

        System.out.println(sb.toString());
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static void incaCalendar() {
        int cnt = 0, result = -1;

        while (cnt * M < lcm) {
            if ((cnt * M + X - Y) % N == 0) {
                result = cnt * M + X;
                break;
            }
            cnt++;
        }
        sb.append(result).append("\n");
    }
}
