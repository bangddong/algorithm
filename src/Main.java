import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /**
     * 동전이 N개만큼 주어짐.
     * 그 동전으로 만들어야할 합이 주어짐.
     * N개 만큼 랜덤한 액수가 적힌 동전이 주어짐.
     */
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int totCoin = Integer.parseInt(st.nextToken()); // 코인 갯수
        int goalPrice = Integer.parseInt(st.nextToken()); // 목표 금액
        int sumCoin = 0; // 필요한 동전의 합계

        int[] kinds = new int[totCoin];
        for (int i = 0; i < totCoin; i++) {
            kinds[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = (totCoin - 1); i >= 0; i--) {
            if (goalPrice >= kinds[i]) {
                count += (goalPrice / kinds[i]);
                goalPrice = (goalPrice % kinds[i]);
            }
        }
        System.out.println(sumCoin);
        br.close();
    }
}
