
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int ans = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[] arr = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                if (matrix[i][j] == '1') arr[j]++;
                else arr[j] = 0;
            ans = Math.max(ans, largestRectangle(arr));
        }
        return ans;
    }

    public int largestRectangle(int[] nums){
        int n = nums.length;
        int[] st = new int[n+1];
        int ptr = -1;
        int ans = 0;
        for(int i=0; i<=n; i++){
            int val = i < n ? nums[i] : 0;
            while(ptr >=0 && nums[st[ptr]] > val){
                int idx = st[ptr--];
                int j = ptr < 0 ? -1 : st[ptr];
                ans = Math.max(ans,(i-j-1)*nums[idx]);
            }
            st[++ptr] = i;
        }
        return ans;
    }
}