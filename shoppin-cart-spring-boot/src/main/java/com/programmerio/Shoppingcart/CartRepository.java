package com.programmerio.Shoppingcart;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartRepository  extends JpaRepository<CartModel, Long>  {
    CartModel findByItemId(long itemId);
    @Transactional
    @Modifying
    @Query("update CartModel set item_quantity = :itemQuantity where id = :id")
    void updateItem(@Param("id") long id, @Param("itemQuantity") int itemQuantity);
}
