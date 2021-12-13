package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_11724 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static ArrayList<Integer>[] A;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) { // 인접 리스트 초기화
            A[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) { // 각 정점 간선정보 add
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            // 양방향 그래프
            A[x].add(y);
            A[y].add(x);
        }
        solution();
    }

    static void solution() {
        int answer = 0;
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visit[i]) { // 아직 방문하지 않았다면
                //BFS(i);
                DFS(i);
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void BFS(int x) {
        visit[x] = true; // 방문처리
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        while(!queue.isEmpty()) {
            x = queue.poll();
            for (int y : A[x]) {
                if (!visit[y]) {
                    queue.add(y);
                    visit[y] = true;
                }
            }
        }
    }

    static void DFS(int x) {
        visit[x] = true;
        for (int y : A[x]) {
            if (!visit[y]) {
                DFS(y);
            }
        }
    }
}
