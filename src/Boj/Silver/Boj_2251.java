package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2251 {
    // 물통의 현재상태와 물을 붓는 행위
    public static class State {
        int[] X;
        State(int[] _X) {
            X = new int[3];
            System.arraycopy(_X, 0, X, 0, 3);
        }
        // A -> B or A -> C or B -> A or B -> C or C -> A or C -> B로 물 이동
        State move(int from, int to, int[] limit) {
            int[] nX = new int[] {X[0], X[1], X[2]};
            // 옮기는쪽, 받는쪽의 물 양이 물통의 한계치보다 큰가?
            if (X[from] + X[to] >= limit[to]) {
                nX[from] -= limit[to] - X[to]; // 주는쪽은 받는쪽의 여유공간
                nX[to] = limit[to]; // 받는쪽은 가득 참
            } else {
                nX[to] += nX[from];
                nX[from] = 0;
            }
            return new State(nX);
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visit;

    public static void main(String[] args) throws IOException {
        limit = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) limit[i] = Integer.parseInt(st.nextToken());
        visit = new boolean[205][205][205];
        possible = new boolean[205];
        solution();
    }

    static void solution() {
        BFS(limit[2]);
        for (int i = 0; i <= limit[2]; i++) {
            if (possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    static void BFS(int x3) {
        Queue<State> queue = new LinkedList<>();
        visit[0][0][x3] = true;
        queue.add(new State(new int[] {0, 0, x3}));

        while(!queue.isEmpty()) {
            State st = queue.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    State nxt = st.move(from, to, limit);

                    if(!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        queue.add(nxt);
                    }
                }
            }
        }
    }
}
