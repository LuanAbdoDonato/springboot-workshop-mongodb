package workshop.springboot.mongodb.estudo.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workshop.springboot.mongodb.estudo.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User luan = new User("1", "Luan", "luan@gmail.com");
        User maria = new User("2", "Maria", "maria@gmail.com");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(luan, maria));

        return ResponseEntity.ok().body(list);
    }

}
