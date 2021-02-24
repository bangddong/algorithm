import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 1000에서 임의의 값을 빼고 남은값을
    // 500, 100, 50, 10, 5, 1을 이용 가장 적게 뺀 수
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());
        int cnt = 0;

        while(n>0) {
            if((n - 500) >= 0) {
                n -= 500;
                cnt++;
            }else if((n - 100) >= 0) {
                n -= 100;
                cnt++;
            }else if((n - 10) >= 0) {
                n -= 10;
                cnt++;
            }
        }
        // 커밋 날라감
        System.out.println(cnt);

    }
}
