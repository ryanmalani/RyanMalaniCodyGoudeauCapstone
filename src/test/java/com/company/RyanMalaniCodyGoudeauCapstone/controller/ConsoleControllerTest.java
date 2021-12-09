package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldCreateConsole() {
    }

    @Test
    public void shouldGetConsoleById() {
    }

    @Test
    public void shouldGetAllConsoles() {
    }

    @Test
    public void shouldGetConsolesByManufacturer() {
    }

    @Test
    public void shouldUpdateConsole() {
    }

    @Test
    public void shouldDeleteConsole() {
    }
}