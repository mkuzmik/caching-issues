package com.miquido.blog.cachingissues;

import java.util.List;

public interface PersonService {

  List<Person> findByAgeBetween(Integer lower, Integer upper);

  List<Person> findByName(String name);

  Person save(Person entity);

  void deleteById(Long id);
}
