package com.programmerio.Shoppingcart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

        import java.util.ArrayList;
        import java.util.List;
        import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.CrossOrigin;
        import org.springframework.web.bind.annotation.DeleteMapping;
        import org.springframework.web.bind.annotation.GetMapping;
        import org.springframework.web.bind.annotation.PathVariable;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.PutMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestParam;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ShoppingController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/items")
    public ResponseEntity<List<ItemsModel>> getAllItems() {
        try {
            List<ItemsModel> itemsModel = itemRepository.findAll().stream().filter(item -> !item.isDeleted()).collect(Collectors.toList());
            System.out.println(itemsModel);
            if (itemsModel.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(itemsModel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemsModel> getItemById(@PathVariable("id") long id) {
        Optional<ItemsModel> itemData = itemRepository.findById(id);

        if (itemData.isPresent()) {
            return new ResponseEntity<>(itemData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addItem")
    public ResponseEntity<ItemsModel> createItem(@RequestBody ItemsModel item) {
        try {
            ItemsModel itemResponse = itemRepository
                    .save(new ItemsModel(item.getName(), item.getDescription(), item.getPrice()));
            return new ResponseEntity<>(itemResponse, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<ItemsModel> updateItem(@PathVariable("id") long id, @RequestBody ItemsModel item) {
        Optional<ItemsModel> itemData = itemRepository.findById(id);

        if (itemData.isPresent()) {
            ItemsModel itemResponse = itemData.get();
            itemResponse.setName(item.getName());
            itemResponse.setDescription(item.getDescription());
            itemResponse.setPrice(item.getPrice());
            return new ResponseEntity<>(itemRepository.save(itemResponse), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable("id") long id) {
        try {
            Optional<ItemsModel> itemData = itemRepository.findById(id);
            if (itemData.isPresent()) {
                ItemsModel itemResponse = itemData.get();
                itemResponse.setDeleted(true);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}