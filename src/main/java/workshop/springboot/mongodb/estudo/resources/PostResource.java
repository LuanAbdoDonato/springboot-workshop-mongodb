package workshop.springboot.mongodb.estudo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workshop.springboot.mongodb.estudo.domain.Post;
import workshop.springboot.mongodb.estudo.service.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);

        return ResponseEntity.ok().body(post);
    }
}
