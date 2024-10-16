package workshop.springboot.mongodb.estudo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.springboot.mongodb.estudo.domain.User;
import workshop.springboot.mongodb.estudo.repository.UserRepository;
import workshop.springboot.mongodb.estudo.resources.UserResource;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        List<User> list = repository.findAll();

        return list;
    }
}
