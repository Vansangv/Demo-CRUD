package com.example.demo.dynamiccontact.Repository;

import com.example.demo.dynamiccontact.etity.dynamiccontact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface dynamiccontactRepository extends JpaRepository<dynamiccontact,Integer> {
    boolean existsByName(String Name);
}
