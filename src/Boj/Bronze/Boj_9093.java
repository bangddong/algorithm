package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_9093 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        while (n --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                reverse(st.nextToken());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void reverse(String word) {
        for (int i = word.length() - 1; i >= 0; i--) {
            sb.append(word.charAt(i));
        }
        sb.append(" ");
    }

}
