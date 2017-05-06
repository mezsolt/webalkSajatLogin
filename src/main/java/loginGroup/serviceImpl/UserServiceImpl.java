package loginGroup.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loginGroup.entity.User;
import loginGroup.repository.UserRepository;
import loginGroup.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Iterable<User> listAllUser() {
		return userRepository.findAll();
	}

	@Override
	public void newUser(User newUser) {
		userRepository.save(newUser);
		
	}

	@Override
	public void deleteUser(long id) {
		userRepository.delete(id);
		
	}

	@Override
	public User findUser(long id) {
		return userRepository.findOne(id);
	}

	@Override
	public User findOneByUsername(String username) {
		return userRepository.findOneByUsername(username);
	}

}
