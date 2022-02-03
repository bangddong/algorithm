package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String[] A = br.readLine().split("\\-");

        // 초기값 세팅
        int answer = splitAdd(A[0]);
        // 다음 -를 만날 때 까지의 합을 뺀다
        for (int i = 1; i < A.length; i++) answer -= splitAdd(A[i]);

        System.out.println(answer);
    }

    static int splitAdd(String str) {
        String[] A = str.split("\\+");
        int sum = 0;

        for (String s : A) sum += Integer.parseInt(s);

        return sum;
    }
}
