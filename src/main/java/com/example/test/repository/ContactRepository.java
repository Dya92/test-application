package com.example.test.repository;

import com.example.test.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

//    @Query(value = "SELECT * FROM contacts c WHERE c.full_name LIKE %:keyword%", nativeQuery = true)
//    List<Contact> findByKeyword(@Param("keyword") String keyword);
}
