package com.miquido.blog.cachingissues;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@SuppressWarnings("unused")
interface PersonRepository extends CrudRepository<Person, Long> {

  List<Person> findByAgeBetween(Integer lower, Integer upper);

  List<Person> findByName(String name);
}
