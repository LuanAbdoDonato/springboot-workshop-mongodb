package workshop.springboot.mongodb.estudo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workshop.springboot.mongodb.estudo.domain.Post;
import workshop.springboot.mongodb.estudo.repository.PostRepository;
import workshop.springboot.mongodb.estudo.service.exception.ObjectNotFoundException;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository repository;

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);

        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
}
