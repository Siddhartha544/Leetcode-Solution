class Solution {
        
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length  > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int n1 = nums1.length;
        int n2 = nums2.length;
        int l = 0;
        int r = n1;
        while (r >= l) {
            int c1 = (l + r) / 2;
            int c2 = (n1 + n2 + 1) / 2 - c1;
            int l1; int l2; int r1; int r2;
            if (c1 == 0)
                l1 = Integer.MIN_VALUE;
            else
                l1 = nums1[c1 - 1];
            if (c2 == 0)
                l2 = Integer.MIN_VALUE;
            else
                l2 = nums2[c2 - 1];
            if (c1 == n1)
                r1 = Integer.MAX_VALUE;
            else
                r1 = nums1[c1];
            if (c2 == n2)
                r2 = Integer.MAX_VALUE;
            else
                r2 = nums2[c2];
            
            if (l1 <= r2 && l2 <= r1) {
                if ((n1 + n2) % 2 == 0)
                    return (double)(Math.max(l1, l2) + Math.min(r1, r2) ) / 2;
                else
                    return (double)Math.max(l1, l2);
            }
            else if (l1 > r2)
                r = c1 - 1;
            else
                l = c1 + 1;
        }
        return (double) 0;
    }
}