class Solution {
    public int addMinimum(String word) {
        int count = 0;
        String abc = "abc";
        int i =0,j=0;

        while(i < word.length()){
            j = j % 3;

            if(abc.charAt(j) == word.charAt(i)){
                j++; i++;
            }else{
                count++;
                j++;
            }

        }
        return count + (3-j);
        
    }
}