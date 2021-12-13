package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10872 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int num;
    public static void main(String[] args) throws IOException {
        num = Integer.parseInt(br.readLine());
        System.out.println(solution(num, 1));
    }

    static int solution(int num, int sum) {
        if (num <= 1) {
            return sum;
        } else {
            return solution(num - 1, sum * num);
        }
    }
}
