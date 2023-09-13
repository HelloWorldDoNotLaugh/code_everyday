package com.wy.leetcode.practise_30;

import com.wy.leetcode.tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;


/**
 * @author yuyang.zhang
 * @Description
 * @date 2023/9/6
 */
public class Day20 {

    /**
     * @description 剑指 Offer 07. 重建二叉树
     * @author yuyang.zhang
     * @date 2023/9/6 17:59
     * @param preorder
     * @param inorder
     * @return com.wy.leetcode.tree.TreeNode
     *
     *    preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     *
     *    根据前序遍历的结果可以先确定  3 一定是根节点。
     *    再到中序遍历中可以确定 左子树 9， 右子树 15， 20，7
     *
     *    这个例子中整棵树的左子树就只有 9，所以左子树✅
     *
     *    对于右子树 15 20 7
     *    依据前序遍历：20是根节点，再根据中序确定 15在左子树，7在右子树。
     *
     *    整体思路还是递归，先找根节点，构建左子树，右子树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }

        // 找到根节点在中序遍历中的index
        int rootIndex = getRootIndex(inorder, root.val);

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, leftInorder.length+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, leftInorder.length + 1, preorder.length);

        root.left = buildTree(leftPreorder, leftInorder);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

    private int getRootIndex(int[] inorder, int root) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }

        throw new NullPointerException("Not Found Root");
    }


    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        }

        if (n < 0) {
            n = n * -1;
            x = 1 / x;
        }


        double result = 1;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }

        return result;
    }


    /**
     * @description 剑指 Offer 33. 二叉搜索树的后序遍历序列
     * @author HelloWorld
     * @create 2023/9/13 16:44
     * @param postorder
     * @return boolean
     *  二叉搜索树一定满足 左 < 根 < 右
     *  所以依次检查是否满足这个关系
     */
    public boolean verifyPostorder(int[] postorder) {
        // 当树的长度 <= 2时，因为无法判定左子树和右子树，所以一定是后续结果
        if (postorder.length <= 2) {
            return true;
        }

        int root = findRoot(postorder);
        int[] leftChild = findLeftChild(postorder, root);
        int[] rightChild = findRightChild(postorder, leftChild.length, root);

        if (leftChild.length + rightChild.length + 1 != postorder.length) {
            return false;
        }

        boolean leftIsOk = verifyPostorder(leftChild);
        boolean rightIsOk = verifyPostorder(rightChild);

        return leftIsOk && rightIsOk;
    }

    /**
     * @description 寻找根节点：对于二叉搜索树后序遍历 根一定是最后一个元素
     * @author HelloWorld
     * @create 2023/9/13 17:31
     * @param postorder
     * @return int
     */
    private int findRoot(int[] postorder) {
        return postorder[postorder.length - 1];
    }

    /**
     * @description 寻找左子树：从第一个元素开始 到 第一个大于根的元素为止
     * @author HelloWorld
     * @create 2023/9/13 17:32
     * @param postorder
     * @param root
     * @return int[]
     */
    private int[] findLeftChild(int[] postorder, int root) {
        return findChild(postorder, 0, root, (a,b) -> a < b);
    }

    /**
     * @description 寻找右子树：从左子树的最后一个元素的下一位置开始 到 第一个小于root的元素为止
     * @author HelloWorld
     * @create 2023/9/13 17:34
     * @param postorder
     * @param startIndex
     * @param root
     * @return int[]
     */
    private int[] findRightChild(int[] postorder, int startIndex, int root) {
        return findChild(postorder, startIndex, root, (a,b) -> a > b);
    }

    private int[] findChild(int[] postorder, int startIndex, int root, BiPredicate<Integer, Integer> comparator) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = startIndex; i < postorder.length; i++) {
            if (comparator.test(postorder[i], root)) {
                list.addLast(postorder[i]);
            } else {
                break;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }



    public static void main(String[] args) {
        Day20 day20 = new Day20();

        System.out.println(day20.verifyPostorder(new int[]{1,2,5,10,6,9,4,3}));
    }
}
