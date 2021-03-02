package com.example.krasivohobi.repository;

import com.example.krasivohobi.model.entity.CommentEntity;
import com.example.krasivohobi.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
