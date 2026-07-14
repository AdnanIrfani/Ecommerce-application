package com.ecommerce.demo.Repository;

import com.ecommerce.demo.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Items,Long> {
}
