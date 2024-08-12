package com.keyin.Trees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TreeController {

    @Autowired
    private TreeRepository treeRepository;

    @Autowired
    private BinaryTreeJsonConverter jsonConverter;

    @Autowired
    private TreeEntityJsonConverter treeEntityJsonConverter;

    @Autowired
    private TreeService treeService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/enter-numbers")
    public String numbers() {
        return "numbers";
    }

    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam String numbers, @RequestParam(required = false, defaultValue = "false") boolean balanced, Model model)  {
        TreeEntity treeEntity;
        if (balanced) {
            treeEntity = treeService.createBalancedTree(parseNumbers(numbers));
        } else {
            treeEntity = treeService.createBST(parseNumbers(numbers));
        }
        String treeJson = treeEntityJsonConverter.toJson(treeEntity);
        model.addAttribute("treeJson", treeJson);
        return "numbers";
    }

    private List<Integer> parseNumbers(String numbers) {
        String[] individualNumbers = numbers.split(",");
        List<Integer> result = new ArrayList<>();
        for (String individualNumber : individualNumbers) {
            int number = Integer.parseInt(individualNumber.trim());
            if (!result.contains(number)) {
                result.add(number);
        }}
        return result;
    }

    @GetMapping("/previous-trees")
    public String getPreviousTrees(Model model) {
        List<TreeEntity> previousTrees = treeService.getPreviousTrees();
        List<String> previousTreesJson = new ArrayList<>();
        for (TreeEntity treeEntity : previousTrees) {
            String treeJson = treeEntityJsonConverter.toJson(treeEntity);
            previousTreesJson.add(treeJson);
        }
        model.addAttribute("previousTreesJson", previousTreesJson);
        return "numbers";
    }
}
