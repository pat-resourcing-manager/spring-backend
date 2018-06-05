package resourceManager;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Skill {

    @Id @GeneratedValue private Long id;

    private String name;

    private Skill() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}