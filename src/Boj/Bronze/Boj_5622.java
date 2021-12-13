package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_5622 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static String str = "";

    // 1. 입력된 문자가 어떤 번호인지(0~9) 확인
    // 2. 해당 번호가 몇초 걸리는지 확인 (번호 + 1)
    public static void main(String[] args) throws IOException {
        str = br.readLine();
        sumConvertToNumber();
    }

    static void sumConvertToNumber() {
        int sum = 0;
        for (char x : str.toCharArray()) {
            if (x >= 'A' && x <= 'C') {
                sum += 3;
            } else if (x >= 'D' && x <= 'F') {
                sum += 4;
            } else if (x >= 'G' && x <= 'I') {
                sum += 5;
            } else if (x >= 'J' && x <= 'L') {
                sum += 6;
            } else if (x >= 'M' && x <= 'O') {
                sum += 7;
            } else if (x >= 'P' && x <= 'S') {
                sum += 8;
            } else if (x >= 'T' && x <= 'V') {
                sum += 9;
            } else {
                sum += 10;
            }
        }
        System.out.println(sum);
    }
}
