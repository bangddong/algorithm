public class Factorial {
    public int factorialFunc(int n) {
        int fac = 1;
        for (int i = 2; i < n + 1; i++) {
            fac = fac * i;
        }
        return fac;
    }

    public int factorialFunc2(int n) {
        if (n > 1) {
            return n * factorialFunc(n - 1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Factorial fObject = new Factorial();
        System.out.println(fObject.factorialFunc2(5));
    }
}
