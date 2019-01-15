package com.example.demo.jpa.repository;

import com.example.demo.jpa.entity.UseBuyerCollect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UseBuyerCollectRepository extends JpaRepository<UseBuyerCollect,String>{
    List<UseBuyerCollect> findByUserId(String userId);
    Integer countByUserId(String userId);

    @Transactional
    @Modifying
    @Query("update UseBuyerCollect u set u.collectType = :collectType where u.id = :id")
    int modifyById(@Param("collectType") Integer collectType, @Param("id") String id);
}
