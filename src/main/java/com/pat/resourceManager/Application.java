package com.pat.resourceManager;

import com.pat.resourceManager.person.Person;
import com.pat.resourceManager.person.PersonRepository;
import com.pat.resourceManager.skill.Skill;
import com.pat.resourceManager.skill.SkillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan("com")
public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner demo(PersonRepository personRepository, SkillRepository skillRepository) {
        return (String... args) -> {

            personRepository.deleteAll();
            skillRepository.deleteAll();

            Person greg = new Person("1", "Greg");
            Person roy = new Person("2","Roy");
            Person craig = new Person("3", "Craig");

            Skill sql = new Skill("SQL");
            Skill python = new Skill("Python");
            Skill java = new Skill("Java");

            List<Person> team = Arrays.asList(greg, roy, craig);

            List<Skill> allSkills = Arrays.asList(sql, python, java);

            log.info("Before adding our new team members");

            team.stream().forEach(person -> log.info("\t" + person.toString()));

            personRepository.save(greg);
            personRepository.save(roy);
            personRepository.save(craig);

            //greg = personRepository.findByName(greg.getName());
            //greg.hasSkill(sql);
            //greg.hasSkill(python);
            //personRepository.save(greg);

            //roy = personRepository.findByName(roy.getName());
            //roy.hasSkill(sql);
            //personRepository.save(roy);

            //craig = personRepository.findByName(craig.getName());
            //craig.hasSkill(java);
            //personRepository.save(craig);

            //log.info("Lookup each person by name...");
            //team.stream().forEach(person -> log.info(
            //        "\t" + personRepository.findById(person.getName()).toString()));
        };
    }

}