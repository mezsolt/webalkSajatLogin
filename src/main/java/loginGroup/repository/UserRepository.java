package loginGroup.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import loginGroup.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	
	User findOneByUsername(String username);
}
