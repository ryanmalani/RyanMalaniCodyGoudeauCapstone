package com.company.RyanMalaniCodyGoudeauCapstone.service;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.ConsoleInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.dao.GameInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.dao.T_ShirtInventoryDao;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceLayerTest {

    ServiceLayer serviceLayer;
    GameInventoryDao gameInventoryDao;
    ConsoleInventoryDao consoleInventoryDao;
    T_ShirtInventoryDao t_shirtInventoryDao;

    @Before
    public void setUp() throws Exception {
        setUpGameInventoryDaoMock();
        setUpConsoleInventoryDaoMock();
        setUpT_ShirtInventoryDaoMock();

        serviceLayer = new ServiceLayer(gameInventoryDao, consoleInventoryDao, t_shirtInventoryDao);
    }

    @Test
    public void

}