package com.keyin;

import com.keyin.Trees.TreeEntity;
import com.keyin.Trees.TreeRepository;
import com.keyin.Trees.TreeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TreeServiceTest {

    @Mock
    private TreeRepository treeRepository;

    @InjectMocks
    private TreeService treeService;

    @Test
    void testGetPreviousTrees() {
        TreeEntity tree1 = new TreeEntity();
        TreeEntity tree2 = new TreeEntity();
        List<TreeEntity> expectedTrees = new ArrayList<>();
        expectedTrees.add(tree1);
        expectedTrees.add(tree2);

        when(treeRepository.findAll()).thenReturn(expectedTrees);

        List<TreeEntity> actualTrees = treeService.getPreviousTrees();

        assertEquals(expectedTrees, actualTrees);
    }

    // Test that TreeService interacts with treeRepository
    // and that the getPreviousTrees() method is returning the list
    // of Tree Entity objects as expected.
}