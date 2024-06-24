package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public List<Animal> getAnimals(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable Integer id){
        return animals.get(id);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId() ,new Animal(animal.getId(), animal.getName()));
        return animals.get(animal.getId());
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal){
        animals.put(id,animal);
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable Integer id){
        Animal deletedAnimal = animals.get(id);
        animals.remove(id);
        return deletedAnimal;
    }

}
