import java.util.*;

class TreeNode{
    int val;
    TreeNode left, right;
    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class Tree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int[] node  = {1,2,4,-1,-1,5,-1,-1,3,6,-1,-1,7,8,-1,-1,9,-1,-1};
        // TreeNode root = buildTree( arr, 0);
        TreeNode root = buildTreeUsingPreOrder(node);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrderTraversal(root);
    }

    // constructing Tree with given Pre Order Traversal
    private static int index = -1;
    private static TreeNode buildTreeUsingPreOrder(int[] arr){
        index++;
        if(index == arr.length || arr[index] == -1) return null;
        TreeNode curr = new TreeNode(arr[index]);
        curr.left = buildTreeUsingPreOrder(arr);
        curr.right = buildTreeUsingPreOrder(arr);
        return curr;
    }

    // Constructing Tree with static Array with (Tree property) of left & right child 
    private static TreeNode buildTree(int[] arr, int idx){
        TreeNode curr = null;
        if(idx < arr.length){
            if(arr[idx] == -1) return null;
            curr = new TreeNode(arr[idx]);
            curr.left = buildTree(arr, 2 * idx + 1); // call left child 
            curr.right = buildTree(arr, 2 * idx + 2); // call right child
        }
        return curr;
    }
    // BFS Traversal
    private static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root); // Initially offering root into Queue
        while(!que.isEmpty()){
            int size = que.size();
            for(int i = 0 ; i < size; i++){
                TreeNode curr = que.poll();
                System.out.print(curr.val +" ");
                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
            }
        }
    }
    // DFS Traversal
    private static void preOrder(TreeNode root){
        if(root == null) return; // base case
        System.out.print(root.val +" ");
        preOrder(root.left); // calling left subtree
        preOrder(root.right); // calling right subtree
    }
    private static void inOrder(TreeNode root){
        if(root == null) return; // base case
        inOrder(root.left); // calling left subtree
        System.out.print(root.val +" ");
        inOrder(root.right); // calling right subtree
    }
    private static void postOrder(TreeNode root){
        if(root == null) return; // base case
        postOrder(root.left); // calling left subtree
        postOrder(root.right); // calling right subtree
        System.out.print(root.val +" ");
    }
}
