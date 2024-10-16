package workshop.springboot.mongodb.estudo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import workshop.springboot.mongodb.estudo.domain.User;
import workshop.springboot.mongodb.estudo.dto.UserDTO;
import workshop.springboot.mongodb.estudo.repository.UserRepository;
import workshop.springboot.mongodb.estudo.resources.UserResource;
import workshop.springboot.mongodb.estudo.service.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        List<User> list = repository.findAll();
        return list;
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);

        return user.orElseThrow(() -> new ObjectNotFoundException("Usuário inexistente"));
    }

    public User insert(User user){
        return repository.insert(user);
    }

    public User fromDTO(UserDTO userdto){
        User user = new User(userdto.getId(), userdto.getName(), userdto.getEmail());

        return user;
    }
}
