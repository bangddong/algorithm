import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int bong = 0;

        while(true) {
            if(n % 5 == 0) {
                bong += n / 5;
                System.out.println(bong);
                break;
            } else {
                n -= 3;
                bong++;
            }

            if(n < 0) {
                System.out.println("-1");
                break;
            }
        }
    }
}
