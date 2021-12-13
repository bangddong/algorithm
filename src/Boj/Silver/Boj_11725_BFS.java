package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11725_BFS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static int[] parents;
    static boolean[] visit;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        visit = new boolean[N + 1];
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        solution();
    }

    static void solution() {
        BFS(1);
        for (int i = 2; i <= N; i++) sb.append(parents[i]).append('\n');
        System.out.println(sb.toString());
    }

    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        visit[x] = true;
        queue.add(x);

        while(!queue.isEmpty()) {
            x = queue.poll();
            for (int y : graph[x]) {
                if(!visit[y]) {
                    visit[y] = true;
                    parents[y] = x;
                    queue.add(y);
                }
            }
        }
    }
}
