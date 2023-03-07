package ua.com.alevel.maximumdepthforagiventree;

public class Solution {

    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int nleft = maxDepth(root.left);
        int nright = maxDepth(root.right);

        return nleft > nright ? nleft + 1 : nright + 1;
    }
}