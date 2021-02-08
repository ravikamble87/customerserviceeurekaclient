package org.com.microservice.customer.repository;

import org.com.microservice.customer.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
