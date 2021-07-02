package com.FrieghtFox.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.FrieghtFox.Entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
