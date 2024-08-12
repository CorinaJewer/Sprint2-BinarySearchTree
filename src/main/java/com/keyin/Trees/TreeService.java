package com.keyin.Trees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private BinaryTreeJsonConverter jsonConverter;

    public TreeEntity createBST(List<Integer> numbers) {
        BinarySearchTree tree = new BinarySearchTree();
        for (Integer number : numbers) {
            tree.insertBST(number);
        }
        String treeJson = jsonConverter.toJson(tree);
        TreeEntity treeStructure = new TreeEntity();
        treeStructure.setInputNumbers(numbers.toString());
        treeStructure.setTreeRepresentation(treeJson);
        return treeRepository.save(treeStructure);
    }

    public TreeEntity createBalancedTree(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertBalancedTree(sortedNumbers);
        String treeJson = jsonConverter.toJson(tree);
        TreeEntity treeStructure = new TreeEntity();
        treeStructure.setInputNumbers(numbers.toString());
        treeStructure.setTreeRepresentation(treeJson);
        return treeRepository.save(treeStructure);
    }

    public List<TreeEntity> getPreviousTrees() {
        List<TreeEntity> trees = new ArrayList<>();
        for (TreeEntity treeEntity : treeRepository.findAll()) {
            trees.add(treeEntity);
        }
        return trees;
    }
}