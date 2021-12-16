package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Console;
import com.company.RyanMalaniCodyGoudeauCapstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/consoles")
public class ConsoleController {

    @Autowired
    private ServiceLayer serviceLayer;

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console) {

        return serviceLayer.addConsole(console);
    }

    // Read

    @GetMapping(value = "/id/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsoleById(@PathVariable int id) {

        return serviceLayer.getConsole(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles() {

        List<Console> consoleList = serviceLayer.getAllConsoles();
        return consoleList;
    }

    @GetMapping(value = "/manufacturer/{manufacturer}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer) {

        List<Console> consoleList = serviceLayer.getConsolesByManufacturer(manufacturer);
        return consoleList;
    }

    // Update

    @PutMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable int id, @RequestBody @Valid Console console) {


//        if (console.getId() == null) {
//            console.setId(id);
//        }

        if (console.getId() != id) {
            throw new IllegalArgumentException("Console ID must match parameter given.");
        }

        serviceLayer.updateConsole(console);
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {

        serviceLayer.deleteConsole(id);
    }
}
