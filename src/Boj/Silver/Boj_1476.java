package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1476 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int a = 0, b = 0, c = 0;
        int cnt = 0;
        while (a != E || b != S || c != M) {
            a++;
            if (a > 15) a = 1;
            b++;
            if (b > 28) b = 1;
            c++;
            if (c > 19) c = 1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
