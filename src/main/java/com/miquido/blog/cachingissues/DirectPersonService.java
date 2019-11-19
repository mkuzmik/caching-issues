package com.miquido.blog.cachingissues;

import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@RequiredArgsConstructor
public class DirectPersonService implements PersonService {

  private final PersonRepository repository;

  @Override
  public List<Person> findByAgeBetween(Integer lower, Integer upper) {
    return repository.findByAgeBetween(lower, upper);
  }

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
