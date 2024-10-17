package workshop.springboot.mongodb.estudo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import workshop.springboot.mongodb.estudo.domain.Post;
import workshop.springboot.mongodb.estudo.resources.util.URL;
import workshop.springboot.mongodb.estudo.service.PostService;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = service.findById(id);

        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);

        List<Post> posts = service.findByText(text);

        return ResponseEntity.ok().body(posts);
    }
}
