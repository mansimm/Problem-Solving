//https://youtu.be/-SmH1UavSaE
class Solution1 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        //sign 1 for + op and -1 for - op
        int sum = 0;
        int sign = 1;
        int num = 0;
        int n = s.length();

        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(c>='0'&&c<='9'){// is digit
                num=0;
                while(i<n && c>='0'&& c<='9'){
                    num = num*10+(c-'0');//if more than 1 digits in single number
                    i++;
                    if(i<n){
                        c = s.charAt(i);
                    }
                }
                sum = sum + sign*num;
                i--;
            }else if(c=='+'){
                sign = 1;
            }else if(c=='-'){
                sign = -1;
            }else if(c=='('){
                stack.push(sum);
                stack.push(sign);
                sum = 0 ;
                sign = 1;
            }else if(c==')'){
                sum = sum*stack.pop()+stack.pop();//base of stack sum the sign
            }
        }
        return sum;
    }
}
//Time c = O(n), space c = O(n)
