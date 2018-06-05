package resourceManager;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jRepositories
public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner demo(PersonRepository personRepository, SkillRepository skillRepository) {
        return args -> {

            personRepository.deleteAll();
            skillRepository.deleteAll();

            Person greg = new Person("Greg");
            Person roy = new Person("Roy");
            Person craig = new Person("Craig");

            Skill sql = new Skill("SQL");
            Skill python = new Skill("Python");
            Skill java = new Skill("Java");

            List<Person> team = Arrays.asList(greg, roy, craig);

            List<Skill> allSkills = Arrays.asList(sql, python, java);

            log.info("Before linking up with Neo4j...");

            team.stream().forEach(person -> log.info("\t" + person.toString()));

            personRepository.save(greg);
            personRepository.save(roy);
            personRepository.save(craig);

            greg = personRepository.findByName(greg.getName());
            greg.hasSkill(sql);
            greg.hasSkill(python);
            personRepository.save(greg);

            roy = personRepository.findByName(roy.getName());
            roy.hasSkill(sql);
            personRepository.save(roy);

            craig = personRepository.findByName(craig.getName());
            craig.hasSkill(java);
            personRepository.save(craig);

            log.info("Lookup each person by name...");
            team.stream().forEach(person -> log.info(
                    "\t" + personRepository.findByName(person.getName()).toString()));
        };
    }

}