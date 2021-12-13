package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_11725_DFS {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static ArrayList<Integer>[] graph;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        parents = new int[N + 1]; // 부모를 저장할 배열, 각 인덱스의 값이 부모다.
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
        DFS(1, -1);
        //0과 1은 비어있으니 두 번째 인덱스부터 출력하자!
        for (int i = 2; i <= N; i++) sb.append(parents[i]).append('\n');
        System.out.println(sb.toString());
    }

    // x = 다음 노드, parent = 부모 노드
    static void DFS(int x, int parent) {
        for (int y : graph[x]) { // x와 연결된 간선을 살펴보자!
            if (y == parent) continue; // 부모 노드는 제외한다!
            parents[y] = x; // x는 y의 부모다!
            DFS(y, x);
        }
    }
}
