package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class T_ShirtController {

    // Create

    @RequestMapping(value = "/t_shirts", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public T_Shirt createT_Shirt(@RequestBody T_Shirt t_shirt) {
        return null;
    }

    // Read

    @RequestMapping(value = "/t_shirts/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public T_Shirt getT_ShirtById(@PathVariable int id) {
        return null;
    }

    @RequestMapping(value = "/t_shirts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getAllT_Shirts() {
        return null;
    }

    @RequestMapping(value = "/t_shirts/{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getT_ShirtsByColor(@PathVariable String color) {
        return null;
    }

    @RequestMapping(value = "/t_shirts/{size}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getT_ShirtsBySize(@PathVariable String size) {
        return null;
    }

    // Update

    @RequestMapping(value = "/t_shirts", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateT_Shirt(@RequestBody T_Shirt t_shirt) {
        return null;
    }

    // Delete

    @RequestMapping(value = "/t_shirts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteT_Shirt(@PathVariable int id) {
        return null;
    }
}
