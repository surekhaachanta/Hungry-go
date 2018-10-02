package com.food.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.food.models.ItemDao;

@RestController
public class UserController {

    @Autowired
    private ItemDao itemDao;
    
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ResponseEntity<?> getItems() {
         return new ResponseEntity<>(itemDao.findAll(), HttpStatus.OK);
    }

   
   
}
