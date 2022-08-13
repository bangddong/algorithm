package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11655 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        for (char c : str.toCharArray()) {
            sb.append(rot13(c));
        }

        System.out.println(sb.toString());
    }

    static char rot13(char c) {
        if (c >= 'a' && c <= 'z') {
            c += 13;
            if (c > 'z') {
                c -= 26;
            }
        }
        if (c >= 'A' && c <= 'Z') {
            c += 13;
            if (c > 'Z') {
                c -= 26;
            }
        }

        return c;
    }
}
