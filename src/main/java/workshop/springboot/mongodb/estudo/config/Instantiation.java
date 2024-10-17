package workshop.springboot.mongodb.estudo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import workshop.springboot.mongodb.estudo.domain.Post;
import workshop.springboot.mongodb.estudo.domain.User;
import workshop.springboot.mongodb.estudo.repository.PostRepository;
import workshop.springboot.mongodb.estudo.repository.UserRepository;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        postRepository.deleteAll();
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo abraços", maria);
        Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", maria);

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
