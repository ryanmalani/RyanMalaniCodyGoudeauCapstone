package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/t_shirts")
public class T_ShirtController {

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public T_Shirt createT_Shirt(@RequestBody @Valid T_Shirt t_shirt) {
        return null;
    }

    // Read

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public T_Shirt getT_ShirtById(@PathVariable int id) {
        return null;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getAllT_Shirts() {
        return null;
    }

    @GetMapping(value = "/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getT_ShirtsByColor(@PathVariable String color) {
        return null;
    }

    @GetMapping(value = "/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getT_ShirtsBySize(@PathVariable String size) {
        return null;
    }

    // Update

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateT_Shirt(@PathVariable int id, @RequestBody @Valid T_Shirt t_shirt) {
        return null;
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteT_Shirt(@PathVariable int id) {
        return null;
    }
}
