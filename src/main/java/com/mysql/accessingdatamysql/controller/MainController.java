package com.mysql.accessingdatamysql.controller;

import com.mysql.accessingdatamysql.model.User;
import com.mysql.accessingdatamysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path="/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    //map POST request
    @PostMapping(path="/add")
    public ResponseEntity<Object> addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return new ResponseEntity<>("User Succesfully created", HttpStatus.CREATED);
    }

    @GetMapping(path="/all")
    public ResponseEntity<Object> getAllUsers(){
        List<User> users = new ArrayList<>();
        users = (List<User>) userRepository.findAll();

        if(users.isEmpty()){
            return new ResponseEntity<>("No users found", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    //update a user
    @PutMapping(path="/{id}")
    public ResponseEntity<Object> uodateUser(@PathVariable("id") Integer id, @RequestBody User user){
        try{
            Optional<User> result = userRepository.findById(id);
            User temp = result.get();
            temp.setName(user.getName());
            temp.setEmail(user.getEmail());
            temp.setPhone(user.getPhone());
            userRepository.save(temp);
            return new ResponseEntity<>("User is updated succesfully", HttpStatus.OK);
        }catch (Exception e){
            return  new ResponseEntity<>("User is not found", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/{id")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") Integer id){
        try{
            userRepository.deleteById(id);
            return new ResponseEntity<>("User is deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("User to be deleted is not found", HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/{id")
    public  ResponseEntity<Object> getUser(@PathVariable("id") Integer id){
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()){
            return new ResponseEntity<>("User is not found", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }
}
