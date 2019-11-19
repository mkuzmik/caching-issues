package com.miquido.blog.cachingissues;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController {

  private final PersonService personService;

  @GetMapping("/person/findByAge")
  public List<Person> getByAgeRange(@RequestParam("lower") Integer lower,
                                    @RequestParam("upper") Integer upper) {
    return personService.findByAgeBetween(lower, upper);
  }

  @GetMapping("/person/findByName")
  public List<Person> getByAgeRange(@RequestParam("name") String name) {
    return personService.findByName(name);
  }

  @PostMapping("/person")
  public Person save(@RequestBody Person person) {
    return personService.save(person);
  }

  @DeleteMapping("/person")
  public void delete(@RequestParam("id") Long id) {
    personService.deleteById(id);
  }

}
