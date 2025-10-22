package com.joaooliveira.crudProject.business;

import com.joaooliveira.crudProject.infrastructure.entities.User;
import com.joaooliveira.crudProject.infrastructure.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    // Init user service
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    //Saves user
    public void saveUser(User user){
        repository.saveAndFlush(user);
    }

    //Returns All Users
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    //Returns user by id
    public User getUserById(Integer id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found!")
        );
    }

    public User getUserByEmail(String email){
        // Return email or return message case not found
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User not found!")
        );
    }

    //Deletes user by id
    public void deleteUserById(Integer id){
        repository.deleteById(id);
    }

    //Update user by id
    public void updateUserById(Integer id, User user){
        //Gets user to update
        User userEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        User userUpdated = User.builder()
                .email(user.getEmail() != null ? user.getEmail() : userEntity.getEmail())
                .name(user.getName() != null ? user.getName() : userEntity.getName())
                .id(userEntity.getId())
                .build();

        repository.saveAndFlush(userUpdated);
    }
}
