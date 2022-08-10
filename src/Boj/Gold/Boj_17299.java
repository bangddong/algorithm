package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_17299 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[n];
        Arrays.fill(result, -1);

        int[] series = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            series[i] = Integer.parseInt(st.nextToken());
            map.put(series[i], map.getOrDefault(series[i], 0) + 1);
        }

        stack.push(series.length - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && map.get(series[stack.peek()]) <= map.get(series[i])) {
                stack.pop();
            }
            if (!stack.isEmpty() && map.get(series[stack.peek()]) > map.get(series[i])) {
                result[i] = series[stack.peek()];
            }
            stack.push(i);
        }

        for (int num : result) sb.append(num).append(" ");
        System.out.println(sb.toString());
    }
}
