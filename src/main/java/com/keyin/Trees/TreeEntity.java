package Trees;
import jakarta.persistence.*;

@Entity
public class TreeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String inputNumbers;

    @Column(columnDefinition = "LONGTEXT")
    private String treeRepresentation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputNumbers() {
        return inputNumbers;
    }

    public void setInputNumbers(String inputNumbers) {
        this.inputNumbers = inputNumbers;
    }

    public String getTreeRepresentation() {
        return treeRepresentation;
    }

    public void setTreeRepresentation(String treeRepresentation) {
        this.treeRepresentation = treeRepresentation;
    }
}
