package com.example.krasivohobi.repository;

import com.example.krasivohobi.model.entity.ArticleEntity;
import com.example.krasivohobi.model.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
