package com.company.RyanMalaniCodyGoudeauCapstone.dao;

import com.company.RyanMalaniCodyGoudeauCapstone.model.Console;

import java.util.List;

public interface ConsoleInventoryDao {

    Console getConsole(int id);
    List<Console> getAllConsoles();
    Console addConsole(Console console);
    void updateConsole(Console console);
    void deleteConsole(int id);
    List<Console> getConsolesByManufacturer(String manufacturer);
}
