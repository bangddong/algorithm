package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1158 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 1; i <= n; i++) queue.add(i);
        while(!queue.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                queue.add(queue.poll());
            }
            array.add(queue.poll());
        }
        sb.append("<");
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i == array.size() - 1) break;
            sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb.toString());
    }
}
