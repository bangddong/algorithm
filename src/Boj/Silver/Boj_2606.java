package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2606 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int V, E, virus = -1;
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }
        visit = new boolean[V + 1];
        solution();
    }

    static void solution() {
//        DFS(1);
        BFS(1);
        System.out.println(virus);
    }

    static void DFS(int x) {
        visit[x] = true;
        virus++;
        for (int y : graph[x]) {
            if (!visit[y]) {
                DFS(y);
            }
        }
    }

    static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visit[x] = true;
        while(!queue.isEmpty()) {
            x = queue.poll();
            virus++;
            for (int y : graph[x]) {
                if (!visit[y]) {
                    queue.add(y);
                    visit[y] = true;
                }
            }
        }
    }
}
