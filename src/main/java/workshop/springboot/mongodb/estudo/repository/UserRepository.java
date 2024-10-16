package workshop.springboot.mongodb.estudo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import workshop.springboot.mongodb.estudo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
