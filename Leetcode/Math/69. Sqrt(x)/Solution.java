class Solution {
    public int mySqrt(int x) {
        if(x==1 || x==0){
            return x;
        }
        long l = 0;
        long r = x;
        while(l<=r){
            long mid = (l+r)/2;
            long sqr = mid*mid;
            if(sqr == x){
                return (int)mid;
            }
            if(sqr < x){
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        return (int)r;
    }
}
/*
Time c = O(logn)
Space c = O(1)
*/
