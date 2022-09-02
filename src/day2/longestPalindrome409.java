package day2;

/**
 * @Package:day2
 * @Author: wyb
 * @DATE:2022/8/31
 * @Description: 力扣 T409
 */
public class longestPalindrome409 {
    public static void main(String[] args) {
        String s = "zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez";
        System.out.println(longestPalindrome(s));
    }


    public static int longestPalindrome(String s) {
        if (s.length() == 1){
            return 1;
        }
        int[] arr = new int['z' - 'A' + 1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c-'A']++;
        }
        int res = 0;
        boolean hasone = false;
        for (int j = 0; j < arr.length; j++) {
            if(arr[j] % 2 == 0){
                res += arr[j];
            }else if (arr[j] > 2){
                hasone = true;
                while(arr[j] > 2){
                    arr[j] = arr[j] - 2;
                    res = res + 2;
                }
            }else{
                hasone = true;
            }
        }
        if (hasone == true){
            res = res + 1;
        }
        return res;
    }
}
