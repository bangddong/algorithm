package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_1406 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (int i = 0; i < str.length(); i++) left.push(str.charAt(i));
        while (n --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "P":
                    left.push(st.nextToken().charAt(0));
                    break;
                case "L":
                    if (!left.isEmpty()) right.push(left.pop());
                    break;
                case "D":
                    if (!right.isEmpty()) left.push(right.pop());
                    break;
                default:
                    if (!left.isEmpty()) left.pop();
                    break;
            }
        }

        while(!left.isEmpty()) right.push(left.pop());
        while(!right.isEmpty()) sb.append(right.pop());
        System.out.println(sb.toString());
    }
}
