package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_9012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        while (n --> 0) {
            String str = br.readLine();
            if (str.length() % 2 != 0) {
                sb.append("NO").append("\n");
                continue;
            }
            if(isNormal(str)) {
                sb.append("YES");
            } else {
                sb.append("NO");
            };
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static boolean isNormal(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (stack.empty()){
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.empty();
    }
}
