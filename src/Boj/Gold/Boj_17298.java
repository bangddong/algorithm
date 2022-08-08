package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_17298 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        for (int num : result) sb.append(num).append(" ");
        System.out.println(sb.toString());
    }
}
