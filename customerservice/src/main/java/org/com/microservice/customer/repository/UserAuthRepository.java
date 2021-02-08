package org.com.microservice.customer.repository;

import org.com.microservice.customer.model.UserAuth;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {
}
