class Solution {
    public int compareVersion(String version1, String version2) {
        version1 += ".";
         version2 += ".";

        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;

        while(i<n || j<m){
            int num1 = 0, num2 = 0;

            while(i<n && version1.charAt(i) == '0'){
                i++;
            }
             while(j<m && version2.charAt(j) == '0'){
                j++;
            }

            while(i<n && version1.charAt(i) != '.'){
                num1 = num1 * 10 + (version1.charAt(i) - '0');
                i++;
            }

            while(j<m && version2.charAt(j) != '.'){
                num2 = num2 * 10 + (version2.charAt(j) - '0');
                j++;
            }

            // System.out.println(num1 + " " + num2);

            if(num1 < num2){
                return -1;
            }else if(num1 > num2){
                return 1;
            }
            i++; j++;

        }

        return 0;

        
    }
}