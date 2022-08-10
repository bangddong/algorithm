package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_1935 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String modify = br.readLine();

        Map<Character, Double> map = new HashMap<>();
        for (int i = 65; i < 65 + n; i++) {
            map.put((char) i, Double.parseDouble(br.readLine()));
        }

        Stack<Double> stack = new Stack<>();
        for (char c : modify.toCharArray()) {
            if (c >= 65 && c <= 90) {
                stack.push(map.get(c));
                continue;
            }
            double back = stack.pop();
            double front = stack.pop();
            switch (c) {
                case '+':
                    stack.push(front + back);
                    break;
                case '-':
                    stack.push(front - back);
                    break;
                case '*':
                    stack.push(front * back);
                    break;
                default:
                    stack.push(front / back);
            }
        }

        System.out.printf("%.2f%n", stack.pop());
    }
}
