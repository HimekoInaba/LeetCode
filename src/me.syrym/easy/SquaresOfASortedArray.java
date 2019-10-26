package me.syrym.easy;

import java.util.Arrays;

public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] qwe = new int[]{-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares(qwe)));
    }

    public static int[] sortedSquares(int[] A) {
        BinarySearchTree bst = new BinarySearchTree();
        for (int a : A) {
            bst.add(a * a);
        }
        return bst.toArray();
    }

    public static class BinarySearchTree {
        private Node root;
        private int size = 0;

        private static class Node {
            int value;
            Node left;
            Node right;

            Node(int value) {
                this.value = value;
            }
        }

        public void add(int obj) {
            if (root == null) {
                root = new Node(obj);
                size++;
                return;
            }
            add(obj, root);
        }

        public boolean contains(int obj) {
            return contains(obj, root);
        }

        public int[] toArray() {
            return toArray(new int[size], root, 0);
        }

        private int[] toArray(int[] arr, Node node, int i) {
            if (node != null) {
                toArray(arr, node.left, i);
                arr[i] = node.value;
                i++;
                toArray(arr, node.right, i);
            }
            return arr;
        }

        private void add(int obj, Node node) {
            if (node.value < obj) {
                if (node.right == null) {
                    node.right = new Node(obj);
                    size++;
                    return;
                }
                add(obj, node.right);
                return;
            }

            if (node.left == null) {
                node.left = new Node(obj);
                size++;
                return;
            }

            add(obj, node.left);
        }

        private boolean contains(int obj, Node node) {
            if (node == null) {
                return false;
            }

            if (obj == node.value) {
                return true;
            }

            if (obj > node.value) {
                return contains(obj, node.right);
            }

            return contains(obj, node.left);
        }
    }
}
