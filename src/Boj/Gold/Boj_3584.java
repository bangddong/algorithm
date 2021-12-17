package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3584 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N;
    static int[] parent;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine()); // 테스트 개수
        while (T --> 0) {
            N = Integer.parseInt(br.readLine()); // 노드의 개수
            parent = new int[N + 1];
            visit = new boolean[N + 1];
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
                parent[y] = x; // y의 부모는 x다.
            }
            // 가장 가까운 조상을 찾아야 하는 노드 두 개
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            solution(x, y);
        }
    }

    static void solution(int x, int y) {
        // x 노드를 루트 노드까지 이동시킨다.
        while(x > 0) {
            visit[x] = true;
            x = parent[x];
        }
        // y 노드를 루트 노드로 이동시키는 과정에서 처음 만난 노드는 최소 공통 조상
        while (y > 0) {
            if (visit[y]) {
                System.out.println(y);
                break;
            }
            y = parent[y];
        }
    }
}
