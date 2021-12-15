package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.ConsoleInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.model.Console;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/consoles")
public class ConsoleController {

    private ConsoleInventoryDao consoleDao;

    // Create

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console createConsole(@RequestBody @Valid Console console) {

        return consoleDao.addConsole(console);
    }

    // Read

    @GetMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsoleById(@PathVariable int id) {

        return consoleDao.getConsole(id);
    }

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles() {

        List<Console> consoleList = consoleDao.getAllConsoles();
        return consoleList;
    }

    @GetMapping(value = "/{manufacturer}")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer) {

        List<Console> consoleList = consoleDao.getConsolesByManufacturer(manufacturer);
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

        consoleDao.updateConsole(console);
    }

    // Delete

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int id) {

        consoleDao.deleteConsole(id);
    }
}
