package com.Leo.Project.resources;

import com.Leo.Project.entities.User;
import com.Leo.Project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.finall();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public  ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findByID(id);
        return ResponseEntity.ok().body(obj);
    }

}
