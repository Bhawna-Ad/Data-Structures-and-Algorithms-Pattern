package BinaryTree;

// https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

import java.util.*;

public class TopViewOfBinaryTree {

    public static List bottomView(Node root) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                Node node = p.node;
                int line = p.line;
                if (!map.containsKey(line))
                    map.put(line, node.val);

                if (node.left != null)
                    q.add(new Pair(node.left, line - 1));
                if (node.right != null)
                    q.add(new Pair(node.right, line + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            list.add(entry.getValue());

        return list;
    }

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {
        Node node;
        int line;

        Pair(Node node, int line) {
            this.node = node;
            this.line = line;
        }
    }
}

