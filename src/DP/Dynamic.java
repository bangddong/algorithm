package DP;

public class Dynamic {
    public int dynamicFunc(int data) {
        Integer[] cache = new Integer[data + 1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i < data + 1; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[data];
    }

    public static void main(String[] args) {
        Dynamic dObject = new Dynamic();
        System.out.println(dObject.dynamicFunc(10));
    }
}
