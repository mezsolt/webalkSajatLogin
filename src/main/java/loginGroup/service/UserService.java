package loginGroup.service;

import java.util.List;

import org.springframework.stereotype.Service;

import loginGroup.entity.User;


@Service
public interface UserService {

	Iterable<User> listAllUser();
	void newUser(User newUser);
	void deleteUser(long id);
	User findUser(long id);
	User findOneByUsername(String username);
	
}
