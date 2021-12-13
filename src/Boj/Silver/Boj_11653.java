package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11653 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        solution();
    }
    static void solution() {
        int i = 2;
        while(n != 1) {
            if (n % i == 0) {
                n = n / i;
                System.out.println(i);
                i = 2;
            }else {
                i++;
            }
        }
    }
}
