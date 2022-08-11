package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_1918 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                if (!stack.isEmpty()) stack.pop();
            } else {
                while (!stack.isEmpty() && checkPriority(stack.peek()) >= checkPriority(c)) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb.toString());
    }

    static int checkPriority(char c) {
        if(c == '*' || c == '/') return 2;
        else if(c == '+' || c == '-') return 1;
        else return 0;
    }
}
