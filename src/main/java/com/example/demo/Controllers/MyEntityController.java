package com.example.demo.Controllers;

import com.example.demo.Entities.MyEntity;
import com.example.demo.Services.MyEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "myentity")
@RequiredArgsConstructor
public class MyEntityController {

    private final MyEntityService myEntityService;

    @GetMapping
    public ResponseEntity<List<MyEntity>> getAllEntities(){
        return ResponseEntity.ok(myEntityService.getAllMyEntities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEntityById(@PathVariable long id){
        try {
            return ResponseEntity.ok(myEntityService.getMyEntityById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<MyEntity> createEntity(@RequestBody MyEntity myEntity){
        return ResponseEntity.status(201).body(myEntityService.createMyEntity(myEntity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEntity(@PathVariable  long id, @RequestBody MyEntity myEntity){
        try {
            return ResponseEntity.ok(myEntityService.updateMyEntity(id, myEntity));
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEntityById(@PathVariable long id){
        try {
            myEntityService.deleteMyEntityById(id);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
