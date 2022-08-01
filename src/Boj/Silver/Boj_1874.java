package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_1874 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int j = 0;
        for (int i = 1; i <= n; i++) {
            stack.push(i);
            sb.append("+").append("\n");
            while (!stack.isEmpty() && stack.peek() == arr[j]) {
                j++;
                stack.pop();
                sb.append("-").append("\n");
            }
        }
        if (!stack.isEmpty()) System.out.println("NO");
        else System.out.println(sb.toString());
    }
}
