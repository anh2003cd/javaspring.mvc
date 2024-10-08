package vn.hoidanit.laptopshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String handleHello() {
        return "hello from service";
    }

    public User handelSaveUser(User user) {
        return this.userRepository.save(user);
    }

    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    public List<User> getUserByEmail(String email) {

        return this.userRepository.findByEmail(email);
    }

    public List<User> getUserByEmailAndAddress(String email, String address) {

        return this.userRepository.findByEmailAndAddress(email, address);
    }

    public User getUserById(long id) {
        return this.userRepository.findById(id);
    }

}
