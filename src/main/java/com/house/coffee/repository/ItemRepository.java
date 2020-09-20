package com.house.coffee.repository;

import com.house.coffee.domainobjects.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
