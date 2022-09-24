package BinarySearchTree;

// https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1

public class FindInorderPredecessorOrSuccessorOfAGivenKeyInBST {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    class Res {
        Node pre = null;
        Node succ = null;
    }

    // Two pass solution
    // find successor and predecessor separately.
    class TwoPassSolution {
        public static void findPreSuc(Node root, Res p, Res s, int key) {
            // add your code here
            Node curr = root;
            while (curr != null) {
                if (curr.data > key) {
                    s.succ = curr;
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }

            curr = root;
            while (curr != null) {
                if (curr.data < key) {
                    p.pre = curr;
                    curr = curr.right;
                } else {
                    curr = curr.left;
                }
            }
        }
    }

    // One pass solution
    class OnePassSolution
    {
        public static void findPreSuc(Node root, Res p, Res s, int key)
        {
            // add your code here
            while(root != null) {
                if(root.data == key) {
                    if(root.left != null) {
                        p.pre = root.left;
                    }

                    if(root.right != null) {
                        s.succ = root.right;
                    }

                    root = root.left;
                } else {
                    if(root.data < key) {
                        p.pre = root;
                        root = root.right;
                    } else {
                        s.succ = root;
                        root = root.left;
                    }
                }
            }
        }
    }
}
