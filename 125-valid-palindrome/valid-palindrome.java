class Solution {
    public boolean isPalindrome(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char it: arr){
            if((it >= 'a' && it <= 'z')){
                sb.append(it);
            }else if(it >= 'A' && it <= 'Z'){
                sb.append(Character.toLowerCase(it));
            }else if(it >= '0' && it <= '9'){
                sb.append(it);
            }
        }
        String parsed = new String(sb);
        arr = parsed.toCharArray();
        int l = 0, r = arr.length-1;

        while(l<r){
            System.out.println(arr[l] + " " + arr[r]);
            if(arr[l] != arr[r]) return false;
            l++; r--;
        }
        return true;
        
    }
}