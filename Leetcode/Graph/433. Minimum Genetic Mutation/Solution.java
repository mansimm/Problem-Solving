class Solution {
    class Pair{
        String gene;
        int mutations;
        public Pair(String gene, int mutations){
            this.gene = gene;
            this.mutations = mutations;
        }
        public String getGene(){
            return gene;
        }
        public int getMutations(){
            return mutations;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> set = new HashSet(Arrays.asList(bank));
        if(!set.contains(endGene)){
            return -1;
        }
        char[] genesArr = new char[]{'A','C','G','T'};
        Queue<Pair> que = new ArrayDeque();
        que.offer(new Pair(startGene, 0));
        while(!que.isEmpty()){
            Pair pair = que.poll();
            String gene = pair.getGene();
            int mutations = pair.getMutations();
            if(gene.equals(endGene)){
                return mutations;
            }
            StringBuilder sb = new StringBuilder(gene);
            for(int i=0;i<gene.length();i++){
                for(char c: genesArr){
                    char temp = gene.charAt(i);
                    if(c!=temp){//avoiding same gene
                        sb.replace(i, i+1, c+"");// to replace only one specified char
                        if(set.contains(sb.toString())){
                            que.offer(new Pair(sb.toString(), mutations+1));
                            set.remove(sb.toString());
                        }
                    }
                    sb.replace(i, i+1, temp+"");
                }
            }
        }
        return -1;
    }
}
