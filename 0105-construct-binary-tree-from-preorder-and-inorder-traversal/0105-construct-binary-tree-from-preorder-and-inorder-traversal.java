class Solution {
    int[] idxData;
    int idx;
    
    
    public TreeNode getTree(int[] preorder, int l, int r) {
        if (l >= r)
            return null;
        
        
        int node = preorder[this.idx++];
        TreeNode n = new TreeNode(node);
        int nodeIdx = this.idxData[node + 3000];
        
        
        n.left = getTree(preorder, l, nodeIdx);
        n.right = getTree(preorder, nodeIdx + 1, r);
        
        
        return n;
    }
    
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.idxData = new int[6001];
        this.idx = 0;
        
        
        for (int i = 0; i < inorder.length; i++)
            this.idxData[inorder[i] + 3000] = i;
        
        
        TreeNode root = getTree(preorder, 0, preorder.length);
        return root;
    }
}