package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_17413 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int idx = 0;

        while (idx < str.length()) {
            char c = str.charAt(idx);

            if (c != ' ' && c != '<') {
                stack.push(c);
            } else if (c == ' ') {
                flushStack();
                sb.append(" ");
            } else {
                flushStack();
                while (c != '>') {
                    sb.append(c);
                    c = str.charAt(++idx);
                }
                sb.append(">");
            }
            idx++;
        }

        flushStack();

        System.out.println(sb.toString());
    }

    public static void flushStack() {
        while (!stack.isEmpty()) sb.append(stack.pop());
    }
}
