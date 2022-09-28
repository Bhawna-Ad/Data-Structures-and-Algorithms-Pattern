package BinaryTree;

// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null)
                return "";
            String serial = "";
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if(node == null)
                    serial += "#,";

                else {
                    serial += node.val+",";
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            //System.out.println(serial);
            return serial;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == "")
                return null;
            String[] values = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            Queue<TreeNode>queue = new LinkedList<>();
            queue.offer(root);

            for(int i=1; i<values.length; i++) {
                TreeNode node = queue.poll();

                if(!values[i].equals("#")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    node.left = left;
                    queue.offer(left);
                }

                if(!values[++i].equals("#")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    node.right = right;
                    queue.offer(right);
                }
            }
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
