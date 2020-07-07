package ads.lesson7;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    private Node root = null;
    private LinkedList<Integer> res;

    public BinaryTree() { }

    public BinaryTree(int root) {
        this.root = new Node(root);
    }

    private Node add(Node node, int el) {
        if (node == null)
            return new Node(el);
        if (el < node.element)
            node.left = add(node.left, el);
        else if (el > node.element)
            node.right = add(node.right, el);
        return node;
    }

    private Node remove(Node node, int el) {
        if (node == null)
            return null;
        if (el == node.element) {
            if (!(node.hasLeft() || node.hasRight()))
                return null;
            if (!node.hasRight())
                return node.left;
            if (!node.hasLeft())
                return node.right;
            node.element = findSmall(node.right);
            node.right = remove(node.right, findSmall(node.right));
            return node;
        }
        if (el < node.element) {
            node.left = remove(node.left, el);
            return node;
        }
        node.right = remove(node.right, el);
        return node;
    }

    private int findSmall(Node node) {
        return node.left == null ? node.element : findSmall(node.left);
    }

    public LinkedList<Integer> BFS() {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            res.add(currentNode.element);
            if (!currentNode.hasRight())
                queue.add(currentNode.right);
            if (!currentNode.hasLeft())
                queue.add(currentNode.left);
        }
        return res;
    }

    private void DFS(Node node) {
        if (node != null) {
            DFS(node.left);
            DFS(node.right);
            res.add(node.element);
        }
    }

    private class Node {

        private int element;
        private Node left;
        private Node right;

        private Node(int element) {
            this.element = element;
            left = null;
            right = null;
        }

        private boolean hasLeft() {
            return left != null;
        }

        private boolean hasRight() {
            return right != null;
        }
    }
}
