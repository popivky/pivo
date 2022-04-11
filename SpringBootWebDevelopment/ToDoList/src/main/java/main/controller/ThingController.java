package main.controller;

import main.model.Thing;
import main.repository.ThingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ThingController {

    @Autowired
    private ThingRepository thingRepository;

    @GetMapping("/things/")
    public List<Thing> list() {

        Iterable<Thing> thingIterable = thingRepository.findAll();
        ArrayList<Thing> things = new ArrayList<>();
        for (Thing thing : thingIterable) {
            things.add(thing);
        }
        return things;

    }

    @PostMapping("/things/")
    public int add(Thing thing) {

        Thing newThing = thingRepository.save(thing);
        return newThing.getId();
    }

    @GetMapping("/things/{id}")
    public ResponseEntity get(@PathVariable int id) {

        Optional<Thing> optionalThing = thingRepository.findById(id);

        if (!optionalThing.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalThing.get(), HttpStatus.OK);
    }

    @DeleteMapping("/things/{id}")
    public void deleteThing(@PathVariable int id) {

        thingRepository.deleteById(id);
    }

    @PutMapping("/things/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestBody String description) {
        Optional<Thing> optionalThing = thingRepository.findById(id);
        if (!optionalThing.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Thing thing = optionalThing.get();
        thing.setDescription(description);
        thingRepository.save(thing);
        return new ResponseEntity(thing, HttpStatus.OK);
    }


}
