package pl.lyszczarzmariusz.SpringBegin.models.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.lyszczarzmariusz.SpringBegin.models.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer> {
}
