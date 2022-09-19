package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1107 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int targetCh = Integer.parseInt(br.readLine());
        int brokenButtonCnt = Integer.parseInt(br.readLine());
        boolean[] isBroken = new boolean[10];

        // 고장난 버튼이 있을경우 초기화
        if (brokenButtonCnt != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            while (st.hasMoreTokens()) {
                int idx = Integer.parseInt(st.nextToken());
                isBroken[idx] = true;
            }
        }

        // 현재 기본 채널은 100번
        int answer = Math.abs(targetCh - 100);

        // 최대 입력까지 확인
        for (int i = 0; i <= 999999; i++) {
            String curCh = Integer.toString(i);
            boolean chkFlag = true;

            // 각 자리수마다 고장난 버튼인지 검증
            for (int j = 0; j < curCh.length(); j++) {
                if (isBroken[curCh.charAt(j) - '0']) {
                    chkFlag = false;
                    break;
                }
            }

            // 고장나지 않은 버튼까지 간 후 차이만큼 + or -로 이동
            if (chkFlag) {
                int calcCh = curCh.length() + Math.abs(i - targetCh);
                answer = Math.min(answer, calcCh);
            }
        }

        System.out.println(answer);
    }
}
