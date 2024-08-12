package com.keyin.Trees;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class BinaryTreeJsonConverter {

    private final ObjectMapper objectMapper;

    public BinaryTreeJsonConverter() {
        this.objectMapper = new ObjectMapper();
    }

    public String toJson(BinarySearchTree tree) {
        try {
            return objectMapper.writeValueAsString(tree);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException("Error serializing BinaryTree to JSON", exception);
        }
    }

    public BinarySearchTree fromJson(String json) {
        try {
            return objectMapper.readValue(json, BinarySearchTree.class);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException("Error deserializing BinaryTree from JSON", exception);
        }
    }
}


