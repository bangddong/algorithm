package Boj.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16472 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;
    static String str;
    static int[] A;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        A = new int[26];
        solution();
    }

    // 번역기는 최대 N개 만큼의 알파벳까지만 저장할 수 있다!
    // 카운트 변수를 만들어 N개 까지만 체크 후 최대 num을 갱신하자
    // 알파벳 소문자는 97 ~ 122까지! (26개), -a을 하면 1 ~ 26까지 나온다!
    static void solution() {
        int answer = 0, cnt = 0;
        for (int rt = 0, lt = 0; rt < str.length(); rt++) {
            A[str.charAt(rt) - 'a']++; // 해당문자 사용횟수 ++
            if (A[str.charAt(rt) - 'a'] == 1) cnt++; // 처음 쓰인거라면 cnt++

            while(cnt > N) { // 인식 가능한 알파벳 한도를 넘었다 !!
                A[str.charAt(lt) - 'a']--; // 하나씩 빼주자
                if (A[str.charAt(lt) - 'a'] == 0) cnt--; // 쓰고있는곳이 없다면 cnt--
                lt++; // 뺏으니 한 칸 전진
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        System.out.println(answer);
    }
}
