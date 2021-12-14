package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.T_Shirt;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/t_shirts")
public class T_ShirtController {

    private List<T_Shirt> t_shirtList;

    private static int idCounter =1;

    public T_ShirtController(){
        t_shirtList = new ArrayList<>();

        t_shirtList.add(new T_Shirt("Medium", "Red", "Limited edition baseball TShirt", "49.99", 700, idCounter++));
        t_shirtList.add(new T_Shirt("Large", "Blue", "Limited edition basketball TShirt", "39.99", 670, idCounter++));
        t_shirtList.add(new T_Shirt("Small", "Black", "Off White TShirt", "80.00", 560, idCounter++));


    }

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public T_Shirt createT_Shirt(@RequestBody @Valid T_Shirt t_shirt) {

        t_shirt.setId(idCounter++);
        t_shirtList.add(t_shirt);

        return t_shirt;
    }

    // Read

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public T_Shirt getT_ShirtById(@PathVariable int id) {

        T_Shirt foundT_Shirt = null;

        for (T_Shirt t_shirt : t_shirtList) {
            if (t_shirt.getId() == id) {
                foundT_Shirt = t_shirt;
                break;
            }
        }

        return foundT_Shirt;

    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<T_Shirt> getAllT_Shirts(@RequestParam(required = false) String size, @RequestParam(required = false) String quantity) {

        List<T_Shirt> returnList = new ArrayList<>();

        if (size != null) {
            for (T_Shirt t_shirt : t_shirtList) {
                if (t_shirt.getSize().contains(size)) {
                    returnList.add(t_shirt);
                }
            }
        } else if (quantity != null) {
            for (T_Shirt t_shirt : t_shirtList) {
                if (t_shirt.getSize().contains(size)) {
                    returnList.add(t_shirt);
                }
            }
        } else {
            returnList = t_shirtList;
        }

        return returnList;
    }

    @GetMapping(value = "/{color}")
    @ResponseStatus(value = HttpStatus.OK)
    public T_Shirt getT_ShirtsByColor(@PathVariable String color) {

        T_Shirt foundT_Shirt = null;

        for (T_Shirt t_shirt : t_shirtList) {
            if (t_shirt.getColor() == color) {
                foundT_Shirt = t_shirt;
                break;
            }
        }

        return foundT_Shirt;
    }

    @GetMapping(value = "/{size}")
    @ResponseStatus(value = HttpStatus.OK)
    public T_Shirt getT_ShirtsBySize(@PathVariable String size) {

        T_Shirt foundT_Shirt = null;

        for (T_Shirt t_shirt : t_shirtList) {
            if (t_shirt.getSize() == size) {
                foundT_Shirt = t_shirt;
                break;
            }
        }

        return foundT_Shirt;
    }

    // Update

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateT_Shirt(@PathVariable int id, @RequestBody @Valid T_Shirt t_shirt) {

        int index =-1;

        for (int i=0; i < t_shirtList.size(); i++) {
            if (t_shirtList.get(i).getId() == id) {
                index = i;
                break;
            }

            if (index >=0 ) {
                t_shirtList.set(index,t_shirt);
            }
        }
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteT_Shirt(@PathVariable int id) {

        int index =-1;

        for (int i = 0; i < t_shirtList.size(); i++) {
            if (t_shirtList.get(i).getId() == id) {
                index = i;
                break;
            }
        }

        if (index >= 0) {
            t_shirtList.remove(index);
        }
    }
}
