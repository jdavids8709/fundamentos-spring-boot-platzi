package com.fundamentosplatzi.springboot.fundamentos.service;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements IUserService {
    private final Log log = LogFactory.getLog(UserService.class);
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveTrasactional(List<User> listUser) {
        try {
            listUser.stream().peek(user -> log.info("User Insert:" + user)).forEach(userRepository::save);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    public List<User> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public User save(User user) {
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public void deleteById(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public User update(User user, Long id) {
        try {
            return userRepository.findById(id).map(
                    user1 -> {
                        user1.setEmail(user.getEmail());
                        user1.setBirthDate(user.getBirthDate());
                        user1.setName(user.getName());
                        return userRepository.save(user1);
                    }
            ).get();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    public List<User> findAll(Pageable pageable) {
        try {
            return userRepository.findAll(pageable).getContent();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

}
