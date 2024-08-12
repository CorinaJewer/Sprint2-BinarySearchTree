package Trees;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TreeEntityJsonConverter {

    private final ObjectMapper objectMapper;

    public TreeEntityJsonConverter() {
        this.objectMapper = new ObjectMapper();
    }

    public String toJson(TreeEntity treeEntity) {
        try {
            ObjectNode node = objectMapper.createObjectNode();
            node.put("id", treeEntity.getId());
            JsonNode treeJsonNode = objectMapper.readTree(treeEntity.getTreeRepresentation());
            node.setAll((ObjectNode) treeJsonNode);
            return objectMapper.writeValueAsString(node);
        } catch (IOException e) {
            throw new RuntimeException("Error serializing TreeEntity to JSON", e);
        }
    }

    public TreeEntity fromJson(String json) {
        try {
            return objectMapper.readValue(json, TreeEntity.class);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing TreeEntity from JSON", e);
        }
    }
}

