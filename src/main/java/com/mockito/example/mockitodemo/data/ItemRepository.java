package com.mockito.example.mockitodemo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockito.example.mockitodemo.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer>{

}
