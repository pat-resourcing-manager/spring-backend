package resourceManager;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;

@RelationshipEntity(type = "HAS_SKILL")
public class PersonSkills {
    @Id @GeneratedValue   private Long relationshipId;
    @Property  private Integer level;
    @StartNode private Person name;
    @EndNode   private Skill name;
}
