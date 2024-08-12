package com.keyin.Trees;

public class BinaryNode {

    public int number;
    public BinaryNode left;
    public BinaryNode right;

    public BinaryNode() {}

    public BinaryNode(int number) {
        this.number = number;
        this.left = null;
        this.right = null;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}

