package org.kd.hibernate.userapp;

import org.kd.hibernate.userapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
