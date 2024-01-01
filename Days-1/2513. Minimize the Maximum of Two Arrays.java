class Solution {
    public int minimizeSet(int d1, int d2, int u1, int u2) {
      final long divLcm = lcm(d1, d2);
      //lcm to find no of elements which are divisible by d1 and d2
      long l = 0;
      long r = Integer.MAX_VALUE;
      //we dont know the exact value of upper limit so ,need to take Maximum integer value

      while (l < r) {
        final long m = (l + r) / 2;
        if (isPossible(m, divLcm, d1, d2, u1, u2))
          r = m;
          //taking the left part in the numberline system from l to mid

        else
          l = m + 1;
          //taking thge part from in the number line from m+1 to max integer value
      }
  
      return (int) l;
    }
  
    // Returns true if we can take uniqueCnt1 integers from [1..m] to arr1 and
    // take uniqueCnt2 integers from [1..m] to arr2.
    private boolean isPossible(long m, long divLcm, int d1, int d2, int u1,int u2) {
      final long cnt1 = m - m / d1;
      final long cnt2 = m - m / d2;
      final long totalCnt = m - m / divLcm;
      return cnt1 >= u1 && cnt2 >= u2 && totalCnt >= u1 + u2;
    }
  
    private long gcd(int a, int b) {
      return b == 0 ? a : gcd(b, a % b);
    }
  
    private long lcm(int a, int b) {
      return a * (b / gcd(a, b));
    }
  }