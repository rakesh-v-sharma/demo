package com.programmerio.Shoppingcart;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ItemRepository itemRepository;
    @GetMapping("/cartItems")
    public ResponseEntity<List<CartItem>> getCartItems(){

        try {
            List<CartItem> cartItems = new ArrayList<>();

            cartRepository.findAll().forEach(cartModel -> {
                ItemsModel itemsModel = itemRepository.findById(cartModel.getItemId()).get();
                CartItem cartItem = new CartItem(itemsModel.getId(),itemsModel.getDescription(), itemsModel.getPrice(), itemsModel.getName(), cartModel.getItemQuantity());
                cartItems.add(cartItem);
            });
           if (cartItems.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(cartItems, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addToCart")
    public ResponseEntity<String> addToCart(@RequestBody CartModel cartModel) {
        try {
            CartModel cartData = cartRepository.findByItemId(cartModel.getItemId());
            System.out.println(cartData);
            System.out.println(cartModel);
            if(cartData != null){
                cartRepository

                        .updateItem(cartData.getId(), cartModel.getItemQuantity());
                return new ResponseEntity<>("Updated successfully", HttpStatus.OK);
            }
            CartModel cartResponse = cartRepository
                    .save(new CartModel(cartModel.getItemId(), cartModel.getItemQuantity()));
            return new ResponseEntity<>("Created cart item ", HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
