  public static int LongToInt(long l) {
    if (l < Integer.MIN_VALUE || l > Integer.MAX_VALUE) {
        throw new IllegalArgumentException
            (l + "is not in range");
    }
    return (int) l;
}
    public int uniquePaths(int m, int n) {
        long ans = 1;
        int finalans = 0;
        if (m > n){
            int temp = m;
            m = n;
            n = temp;
        }
        for (int i = m + n - 2; i >= n; i--){
            ans *= i;
            ans /= (m + n - 1 - i);
        }
        finalans = LongToInt(ans);
        return finalans;
    }
}
