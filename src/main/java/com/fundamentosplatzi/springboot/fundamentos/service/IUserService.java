package com.fundamentosplatzi.springboot.fundamentos.service;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
    public void saveTrasactional(List<User> listUser);
    public List<User> findAll();
    public User save(User user);
    public void deleteById(Long id);

    public User update(User user, Long id);
}
