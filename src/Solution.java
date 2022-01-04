class Solution {
    public int countDigitOne(int n) {
        int k = 0;
        int tem = n;
        int res = 0;
        long base = 1;
        while (tem != 0){
            k++;
            tem /= 10;
        }
        int[] dp = new int[k];
        for (int i = 0; i < k; i++){
            int multi = (int) (n / (base * 10));
            dp[i] = (int) (multi * base);
            int rest = (int) (n % (base * 10));
            dp[i] += Math.min(Math.max(rest - base + 1,0), base);
            base *= 10;
        }
        for (int i: dp) {
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int i = s.countDigitOne(1410065408);
        System.out.println("i = " + i);
    }
}