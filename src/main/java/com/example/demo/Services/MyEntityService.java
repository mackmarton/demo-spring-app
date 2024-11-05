package com.example.demo.Services;

import com.example.demo.Entities.MyEntity;
import com.example.demo.Repositories.MyEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MyEntityService {

    private final MyEntityRepository myEntityRepository;

    public List<MyEntity> getAllMyEntities(){
        return myEntityRepository.findAll();
    }

    public MyEntity getMyEntityById(long id) throws NoSuchElementException {
        return myEntityRepository.findById(id).orElseThrow(()->new NoSuchElementException("Element with ID could not be found!"));
    }

    public MyEntity updateMyEntity(long id, MyEntity myEntity) throws NoSuchElementException {
        if(myEntity.getId() != id) throw new InputMismatchException("Id in request param and entity did not match");
        myEntityRepository.findById(id).orElseThrow(()->new NoSuchElementException("Element with ID could not be found!"));

        return myEntityRepository.save(myEntity);
    }

    public MyEntity createMyEntity(MyEntity myEntity) {
        return myEntityRepository.save(myEntity);
    }

    public void deleteMyEntityById(long id){
        myEntityRepository.findById(id).orElseThrow(()->new NoSuchElementException("Element with ID could not be found!"));
        myEntityRepository.deleteById(id);
    }
}
