package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import com.company.RyanMalaniCodyGoudeauCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/t_shirts")
public class T_ShirtController {

    @Autowired
    private ServiceLayer serviceLayer;

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public T_Shirt createT_Shirt(@RequestBody @Valid T_Shirt t_shirt) {

        serviceLayer.addT_Shirt(t_shirt);

        return t_shirt;
    }

    // Read

    @GetMapping(value = "/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public T_Shirt getT_ShirtById(@PathVariable int id) {


        return serviceLayer.getT_Shirt(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getAllT_Shirts() {

        List<T_Shirt> t_shirtList = serviceLayer.getAllT_Shirts();
        return t_shirtList;
    }

    @GetMapping(value = "/color/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getT_ShirtsByColor(@PathVariable String color) {

        List<T_Shirt> t_shirtList = serviceLayer.getT_ShirtsByColor(color);
        return  t_shirtList;
    }

    @GetMapping(value = "/size/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getT_ShirtsBySize(@PathVariable String size) {

        List<T_Shirt> t_shirtList = serviceLayer.getT_ShirtsBySize(size);
        return t_shirtList;
    }

    // Update

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateT_Shirt(@PathVariable int id, @RequestBody @Valid T_Shirt t_shirt) {

//        if (t_shirt.getId() == id) {
//            t_shirt.setId(id);
//        }

        if (t_shirt.getId() != id) {
            throw new IllegalArgumentException("T_Shirt ID must match parameter given.");
        }

        serviceLayer.updateT_Shirt(t_shirt);
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteT_Shirt(@PathVariable int id) {

        serviceLayer.deleteT_Shirt(id);
    }
}
