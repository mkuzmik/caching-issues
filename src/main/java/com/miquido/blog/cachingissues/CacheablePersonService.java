package com.miquido.blog.cachingissues;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
public class CacheablePersonService implements PersonService {

  private final PersonRepository repository;

  @Cacheable("PERSON")
  @Override
  public List<Person> findByAgeBetween(Integer lower, Integer upper) {
    return repository.findByAgeBetween(lower, upper);
  }

  @Cacheable("PERSON")
  @Override
  public List<Person> findByName(String name) {
    return repository.findByName(name);
  }

  @Override
  public Person save(Person entity) {
    return repository.save(entity);
  }

  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
