Approach-1 (Not A Nice Approach )

class Solution {
    public int pairSum(ListNode head) {
        
        ListNode temp = head;
        
        List<Integer> L = new ArrayList<Integer>();
        
        while(temp!=null){
            L.add(temp.val);
            temp = temp.next;
        }
        int i=0;
        int j=L.size()-1;
        int sum=0,maxSum=0;
        
        while(i<j){
            sum = sum+L.get(i)+L.get(j);
            maxSum=Math.max(maxSum,sum);
            sum=0;
            i++; j--;
        }
        return maxSum;
    }
} 

Approach- (Using Stack )
  
  class Solution {
    public int pairSum(ListNode head) {
        
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head;
        ListNode fast = head.next;
        int max = Integer.MIN_VALUE;

        while(fast!=null)
        {   
            stack.add(slow.val);
            slow=slow.next;
            if(fast.next==null)
            {
                break;
            }
            fast = fast.next.next;
        }
        while(slow!=null)
        {
            int curMax = stack.pop()+slow.val;
            max = Math.max(max,curMax);
            slow=slow.next;
        }
        return max;
    }
}

Approach : 3 (Best & Required Approach Using On LinkedList)

class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse from prev pointer

        ListNode rev = null;
        ListNode curr = head;
        while(curr != slow) {
            ListNode temp = curr.next;
            curr.next = rev;
            rev = curr;
            curr = temp;
        }

        ListNode back = rev;
        ListNode front = slow;
        int ans = 0;
        while(back != null) {
            ans = Math.max(ans , front.val + back.val);
            front = front.next;
            back = back.next;
        }
        return ans;
    }
}
