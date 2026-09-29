class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        char arr[] = s.toCharArray();
        int l = 0, r = arr.length-1;

        while(l < r){
            while(l < arr.length && !set.contains(arr[l])) l++;
            while(r >= 0 && !set.contains(arr[r])) r--;
            
            if(l < r && set.contains(arr[l]) && set.contains(arr[r])){
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++; r--;
            }
        }
        return new String(arr);
    }
}