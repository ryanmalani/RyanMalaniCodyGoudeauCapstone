package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Console;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/consoles")
public class ConsoleController {

    private static int idCounter = 1;

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody Console console) {
        return null;
    }

    // Read

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsoleById(@PathVariable int id) {
        return null;
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles() {
        return null;
    }

    @GetMapping(value = "/{manufacturer}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer) {
        return null;
    }

    // Update

    @PutMapping
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateConsole(@RequestBody Console console) {
        return null;
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {
        return null;
    }
}
