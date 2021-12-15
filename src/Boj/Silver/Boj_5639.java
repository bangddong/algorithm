package Boj.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_5639 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static ArrayList<Integer> A;
    public static void main(String[] args) throws IOException {
        A = new ArrayList<>();
        String str = "";
        // 별도의 종료지점이나 노드의 크기는 정해져 있지 않으니 주는대로 받자!
        while ((str = br.readLine()) != null) A.add(Integer.parseInt(str));
        solution();
    }

    static void solution() {
        DFS(0, A.size() - 1);
        System.out.println(sb.toString());
    }

    static void DFS(int lt, int rt) {
        if (lt > rt) return;
        int mid = lt + 1;
        // 범위를 넘어가지 않는 선에서 중간점을 찾자!
        // 중간점 = 왼쪽 서브트리와 오른쪽 서브트리를 나눌 수 있는 기준점
        while (mid <= rt && A.get(mid) < A.get(lt)) mid++;

        // 왼쪽 서브트리
        DFS(lt + 1, mid - 1);
        // 오른쪽 서브트리
        DFS(mid, rt);
        sb.append(A.get(lt)).append('\n');
    }
}
