package Boj.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1712 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int defaultPrice = 0, producePrice = 0, sellPrice = 0, answer = 0;
    // 1. 판매비용보다 생산 비용이 높으면 손익 분기점을 넘길 수 없으니 -1
    // 2. 투자비용 / (판매비용 - 생산비용) + 1
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        defaultPrice = Integer.parseInt(st.nextToken());
        producePrice = Integer.parseInt(st.nextToken());
        sellPrice = Integer.parseInt(st.nextToken());
        calcBreakPoint();
    }

    static void calcBreakPoint() {
        if (producePrice > sellPrice || producePrice == sellPrice) {
            System.out.println(-1);
            return;
        }
        answer = defaultPrice / (sellPrice - producePrice) + 1;
        System.out.println(answer);
    }
}
