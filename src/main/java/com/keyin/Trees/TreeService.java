package Trees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TreeService {

    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private BinaryTreeJsonConverter jsonConverter;

    public TreeEntity createTree(List<Integer> numbers) {
        BinarySearchTree tree = new BinarySearchTree();
        for (Integer number : numbers) {
            tree.insert(number);
        }
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