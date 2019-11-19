package com.miquido.blog.cachingissues;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import javax.transaction.Transactional;

@SpringBootApplication
@Slf4j
public class CachingIssuesApplication {

  public static void main(String[] args) {
    SpringApplication.run(CachingIssuesApplication.class, args);
  }

  @Bean
  @Transactional
  public CommandLineRunner initializeSamples(PersonRepository repository) {
    return (args) -> {
      repository.save(new Person("Monica", 32));
      repository.save(new Person("Lucas", 14));
      repository.save(new Person("Bill", 16));
      repository.save(new Person("James", 80));
      repository.save(new Person("Jessica", 32));
    };
  }

  @Bean
  public PersonService sampleDataService(Environment environment, PersonRepository personRepository) {

    Boolean cacheEnabled = environment.getProperty("cache.enabled", Boolean.class);

    if (cacheEnabled != null && cacheEnabled) {
      log.info("Creating CACHED version of Person Service");
      return new CacheablePersonService(personRepository);
    } else {
      log.info("Creating DIRECT version of Person Service");
      return new DirectPersonService(personRepository);
    }
  }
}
