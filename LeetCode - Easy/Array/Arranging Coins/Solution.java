 //Arranging Coins
class Solution {
    public int arrangeCoins(int n) {
        int i=1;
        while(i<=n)
        {
            n-=i;
            if(n==0)
            {
                return i;
            }
            i++;
        }
        return i-1;
    }
}
