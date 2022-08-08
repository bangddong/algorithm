package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_10799 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int cnt = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (input.charAt(i - 1) == '(') {
                    cnt += stack.size();
                } else {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);

    }
}
