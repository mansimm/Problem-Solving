class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> ans = new LinkedList<String>();
        
        if(digits==null||digits.length()==0)
        {
            return ans;
        }
        Map<String,char[]> map = new HashMap<>();
        map.put("2","abc".toCharArray());
        map.put("3","def".toCharArray());
        map.put("4","ghi".toCharArray());
        map.put("5","jkl".toCharArray());
        map.put("6","mno".toCharArray());
        map.put("7","pqrs".toCharArray());
        map.put("8","tuv".toCharArray());
        map.put("9","wxyz".toCharArray());
        
        int len = digits.length();
        int i=0;

            for(int j=0;len>=1 && j<map.get(digits.charAt(i)+"").length;j++)
            {
                String y1 = ""+ String.valueOf(map.get(digits.charAt(i)+"")).charAt(j);
                
                if(len==1)
                {
                    ans.add(y1);
                }
                for(int k=0;len>=2 && k<map.get(digits.charAt(i+1)+"").length;k++)
                {
                    String y2 = y1 + String.valueOf(map.get(digits.charAt(i+1)+"")).charAt(k);
                    //System.out.println("y2 : "+y2);
                    if(len==2)
                    {
                        ans.add(y2);
                    }
                    for(int l=0;len>=3 && l<map.get(digits.charAt(i+2)+"").length;l++)
                    {
                        String y3 = y2 + String.valueOf(map.get(digits.charAt(i+2)+"")).charAt(l);
                        //System.out.println("y3 : "+y);
                        if(len==3)
                        {
                            ans.add(y3);
                        }
                        for(int m=0;len==4 && m<map.get(digits.charAt(i+3)+"").length;m++)
                        {
                            String y4 = y3 + String.valueOf(map.get(digits.charAt(i+3)+"")).charAt(m);
                            ans.add(y4);
                            //System.out.println(y4);
                        }
                    }
                }
            }
        
        return ans;
    }
}
