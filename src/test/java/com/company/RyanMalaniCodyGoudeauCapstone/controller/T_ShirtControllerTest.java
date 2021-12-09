package com.company.RyanMalaniCodyGoudeauCapstone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;

public class T_ShirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldCreateT_Shirt() {
    }

    @Test
    public void shouldGetT_ShirtById() {
    }

    @Test
    public void shouldGetAllT_Shirts() {
    }

    @Test
    public void shouldGetT_ShirtsByColor() {
    }

    @Test
    public void shouldGetT_ShirtsBySize() {
    }

    @Test
    public void shouldUpdateT_Shirt() {
    }

    @Test
    public void shouldDeleteT_Shirt() {
    }
}