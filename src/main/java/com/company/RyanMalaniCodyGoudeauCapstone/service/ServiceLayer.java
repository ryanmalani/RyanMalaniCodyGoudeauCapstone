package com.company.RyanMalaniCodyGoudeauCapstone.service;

import com.company.RyanMalaniCodyGoudeauCapstone.dao.ConsoleInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.dao.GameInventoryDao;
import com.company.RyanMalaniCodyGoudeauCapstone.dao.T_ShirtInventoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceLayer {

    private ConsoleInventoryDao consoleInventoryDao;
    private GameInventoryDao gameInventoryDao;
    private T_ShirtInventoryDao t_shirtInventoryDao;

    @Autowired
    public ServiceLayer(ConsoleInventoryDao consoleInventoryDao, GameInventoryDao gameInventoryDao, T_ShirtInventoryDao t_shirtInventoryDao) {

        this.consoleInventoryDao = consoleInventoryDao;
        this.gameInventoryDao = gameInventoryDao;
        this.t_shirtInventoryDao = t_shirtInventoryDao;
    }

    @Transactional

}
