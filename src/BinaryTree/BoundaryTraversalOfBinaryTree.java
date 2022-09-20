package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;

public class BoundaryTraversalOfBinaryTree {

 class TreeNode {
 int data;
 TreeNode left;
 TreeNode right;

 TreeNode(int data) {
 this.data = data;
 this.left = null;
 this.right = null;
 }

 }

    public class Solution {
        public static ArrayList<Integer> traverseBoundary(TreeNode root){
            // Write your code here.
            ArrayList<Integer> list = new ArrayList<>();
            if(!isLeaf(root))
                list.add(root.data);
            addLeftBoundary(root, list);
            addLeaves(root, list);
            addRightBoundary(root, list);
            return list;
        }

        private static void addLeftBoundary(TreeNode root, ArrayList<Integer>list) {
            TreeNode node = root.left;
            while(node != null) {
                if(!isLeaf(node))
                    list.add(node.data);
                if(node.left != null)
                    node = node.left;
                else
                    node = node.right;
            }
        }

        private static void addLeaves(TreeNode node, ArrayList<Integer>list) {
            if(node == null)
                return;

            if(isLeaf(node)) {
                list.add(node.data);
                return;
            }

            addLeaves(node.left, list);
            addLeaves(node.right, list);
        }

        private static void addRightBoundary(TreeNode root, ArrayList<Integer>list) {
            ArrayList<Integer>nodes = new ArrayList<>();
            TreeNode node = root.right;
            while(node != null) {
                if(!isLeaf(node))
                    nodes.add(node.data);
                if(node.right != null)
                    node = node.right;
                else
                    node = node.left;
            }

            Collections.reverse(nodes);
            list.addAll(nodes);
        }

        private static boolean isLeaf(TreeNode node) {
            if(node.left == null && node.right == null)
                return true;
            return false;
        }
    }
}
