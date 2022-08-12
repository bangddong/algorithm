package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10820 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        String str = "";
        while ((str = br.readLine()) != null) {
            arr = new int[4];

            for (char c : str.toCharArray()) {
                checkASCII(c);
            }

            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void checkASCII(char c) {
        if (c >= 'a' && c <= 'z') {
            arr[0]++;
        } else if (c >= 'A' && c <= 'Z') {
            arr[1]++;
        } else if (c >= '0' && c <= '9') {
            arr[2]++;
        } else {
            arr[3]++;
        }
    }
}
