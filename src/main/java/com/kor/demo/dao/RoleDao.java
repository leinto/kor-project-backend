package com.kor.demo.dao;

import java.util.Optional;

import com.kor.demo.model.Role;
import com.kor.demo.model.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName roleName);
}