package com.orud.watchlisttracker.repository;

import com.orud.watchlisttracker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
//    List<User> getAllUsers();
//    User getUserById(Long id);
//    User findByUsername(String username);
//    User addUser(User user);
//    User updateUser(Long id, User user);
//    void deleteUser(Long id);
}
