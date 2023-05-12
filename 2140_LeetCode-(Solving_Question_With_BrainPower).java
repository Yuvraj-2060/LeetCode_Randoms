#Approach-1 (Naive Recursion Approach)
  
  class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        return solve(questions,0,n-1);
    }
    public long solve(int arr[][],int i,int n){
       if(i>n)
           return 0;
        
        long solve = arr[i][0] + solve(arr,i+arr[i][1]+1,n);
        long skip = solve(arr,i+1,n);
        return Math.max(solve,skip);
    }
}


#Approach-2 (Optimal Solution Reduce The Redundant Task)

public long mostPoints(int[][] questions) {
        int n = questions.length;
        Map<Integer, Long> memo = new HashMap<>();
        return solve(questions, 0, n - 1, memo);
    }

    public long solve(int arr[][], int i, int n, Map<Integer, Long> memo) {
        if (i > n)
            return 0;

        if (memo.containsKey(i))
            return memo.get(i);

        long solve = arr[i][0] + solve(arr, i + arr[i][1] + 1, n, memo);
        long skip = solve(arr, i + 1, n, memo);
        long maxPoints = Math.max(solve, skip);
        memo.put(i, maxPoints);
        return maxPoints;
    }
