class Solution {
    public int maxVowels(String s, int k) {
        int cnt=0,maxCnt=0;
        
        for(int i=0;i<=s.length()-1-k+1;i++){
            
            if(cnt==k)
                return maxCnt;
            if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || s.charAt(i)=='o' || s.charAt(i)=='u'){
                cnt++;
                maxCnt = Math.max(maxCnt,cnt);
            }
            else cnt=0;
            
        }return maxCnt;
    }
}

******************************************************* (More Optimized) *********************************************************************

class Solution {
   public int isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
            return 1;
        return 0;
    }

    public int maxVowels(String s, int k) {
        int maxCnt = 0, cnt=0;
        for(int i=0;i<s.length();i++){
            cnt += isVowel(s.charAt(i));
            if(i>=k)
                cnt -= isVowel(s.charAt(i-k));
            max_vow = Math.max(max_vow, cnt);
        }
        return max_vow;    
    }
}
