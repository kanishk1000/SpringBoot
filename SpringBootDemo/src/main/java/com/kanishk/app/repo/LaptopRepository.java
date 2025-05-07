package com.kanishk.app.repo;

import com.kanishk.app.model.Laptop;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepository {

    public void save(Laptop lap){
        System.out.println("Entry saved in database");
    }
}
