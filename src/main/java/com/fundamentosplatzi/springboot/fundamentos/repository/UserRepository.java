package com.fundamentosplatzi.springboot.fundamentos.repository;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("Select u from User u where u.email = :email")
    Optional<User> findByEmai(String email);

    @Query("SELECT u FROM User u WHERE u.name like ?1%")
    List<User> findBySort(String name, Sort sort);

    List<User> findByName(String name);

    Optional<User> findByEmailAndName(String email, String name);

    Optional<User> findByEmailOrName(String email, String name);
    List<User> findByNameLike(String name);
    List<User> findByBirthDateBetween(LocalDate begin, LocalDate finish);

    List<User> findByNameLikeOrderByIdDesc(String name);
}
