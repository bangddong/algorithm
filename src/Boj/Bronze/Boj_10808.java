package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10808 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int[] alphabet = new int[26];

        for (char c : str.toCharArray()) alphabet[c - 'a']++;
        for (int n : alphabet) sb.append(n).append(" ");

        System.out.println(sb.toString());
    }
}
