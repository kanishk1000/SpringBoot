package com.kanishk.app.service;

import com.kanishk.app.model.Laptop;
import com.kanishk.app.repo.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository repo;

    public void addLaptop(Laptop lap){

        repo.save(lap);
    }

    public boolean isGoodForProg(Laptop lap){
        return true;
    }
}
