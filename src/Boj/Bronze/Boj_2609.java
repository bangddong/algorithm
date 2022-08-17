package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2609 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = recursive(a, b);

        System.out.println(gcd);
        System.out.println(a * b / gcd);

    }

    static int recursive(int a, int b) {
        if (b == 0) return a;
        else return recursive(b, a % b);
    }
}
