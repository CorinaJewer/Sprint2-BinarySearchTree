package com.keyin;

import com.keyin.Trees.BinaryNode;
import com.keyin.Trees.BinarySearchTree;
import com.keyin.Trees.BinaryTreeJsonConverter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeJsonConverterTest {

    BinaryTreeJsonConverter testConverter = new BinaryTreeJsonConverter();

    @Test
    void testToJsonString() {
        BinarySearchTree tree = new BinarySearchTree();
        BinaryNode root = new BinaryNode(1);
        root.setRight(new BinaryNode(2));
        root.getRight().setRight(new BinaryNode(3));
        tree.setRoot(root);
        String expectedJsonString = "{\"root\":{\"number\":1,\"left\":null,\"right\":{\"number\":2,\"left\":null,\"right\":{\"number\":3,\"left\":null,\"right\":null}}}}";
        String actualJsonString = testConverter.toJson(tree);

        assertEquals(expectedJsonString, actualJsonString);
    }

    // Tests the serialization of a BinarySearchTree to a JSON string.

    @Test
    void testFromJsonString() {
        String actualJsonString = "{\"root\":{\"number\":1,\"left\":null,\"right\":{\"number\":2,\"left\":null,\"right\":{\"number\":3,\"left\":null,\"right\":null}}}}";
        BinarySearchTree expectedTree = new BinarySearchTree();
        BinaryNode expectedRootNode = new BinaryNode(1);
        expectedRootNode.setRight(new BinaryNode(2));
        expectedRootNode.getRight().setRight(new BinaryNode(3));
        expectedTree.setRoot(expectedRootNode);
        BinarySearchTree actualTree = testConverter.fromJson(actualJsonString);

        assertEquals(expectedTree.getRoot().getNumber(), actualTree.getRoot().getNumber());
    }

    // Tests the deserialization of a JSON string into a BinarySearchTree.
}
