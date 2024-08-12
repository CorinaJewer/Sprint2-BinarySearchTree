package com.keyin.Trees;

import java.util.Collections;
import java.util.List;

public class BinarySearchTree {

    BinaryNode root;

    public BinarySearchTree() {
        root = null;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    void insertBST(int number) {
        BinaryNode newNode = new BinaryNode(number);
        if (root == null) {
            root = newNode;
            return;
        }
        BinaryNode currentNode = root;
        while (true) {
            if (number < currentNode.number) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    currentNode = currentNode.left;
                }
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    public void insertBalancedTree(List<Integer> numbers) {
        Collections.sort(numbers);
        root = createBalancedTree(numbers, 0, numbers.size() - 1);
    }

    private BinaryNode createBalancedTree(List<Integer> numbers, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryNode node = new BinaryNode(numbers.get(mid));
        node.setLeft(createBalancedTree(numbers, start, mid - 1));
        node.setRight(createBalancedTree(numbers, mid + 1, end));
        return node;
    }

    // Sort Numbers
    // Calculate middle index
    // Create new node with value for middle index
    // Create left child of node
    // Calculate middle index with sub-array and assign value to new node
    // Repeat until returns null indicating no child node
    // Build right subtree same
}

