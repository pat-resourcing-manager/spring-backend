package resourceManager;

import org.springframework.data.repository.CrudRepository;

public interface SkillRepository extends CrudRepository<Skill, Long> {

    Skill findByName(String name);
}