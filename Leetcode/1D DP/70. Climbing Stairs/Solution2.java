//1D DP
class Solution2 {
    public int climbStairs(int n) {
        if(n==0 || n==1){
            return 1;
        }
        int temp1 = 1;// 1 way to reach if n=1
        int temp2 = 2;//2 ways to reach if n=2
        for(int i=3;i<=n;i++){//3, 4
            int current = temp1+temp2;//3, 5
            temp1 = temp2;//2, 3
            temp2 = current;//3, 5
        }
        return temp2;
    }
}
//Time c O(n), space c O(1)
