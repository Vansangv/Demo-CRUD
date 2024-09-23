package com.example.demo.dynamiccontact.Controller;


import com.example.demo.dynamiccontact.Repository.dynamiccontactRepository;
import com.example.demo.dynamiccontact.etity.dynamiccontact;
import com.example.demo.dynamiccontact.service.dynamiccontactRequest;
import com.example.demo.dynamiccontact.service.dynamiccontactResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hienthi")
public class dynamiccontactController {
    @Autowired
    dynamiccontactRepository dynamiccontactRepository;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        List<dynamiccontactResponse> list = new ArrayList<>();
        dynamiccontactRepository.findAll().forEach(c -> list.add(c.toResponse()));
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(dynamiccontactRepository.findById(id).isPresent()){
            dynamiccontactRepository.deleteById(id);
            return ResponseEntity.ok("Xóa thành công");
        }else {
            return ResponseEntity.badRequest().body("Không tìm thấy id cần xóa");
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody dynamiccontactRequest dynamiccontactRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder mess = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> mess.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(mess.toString());
        }
        if (dynamiccontactRepository.existsByName(dynamiccontactRequest.getName())) {
            return ResponseEntity.badRequest().body("Name đã tồn tại");
        }

        dynamiccontact products = dynamiccontactRequest.toEntity();
        dynamiccontactRepository.save(products);
        return ResponseEntity.ok("thêm thành công");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody dynamiccontactRequest dynamiccontactRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if (dynamiccontactRepository.existsByName(dynamiccontactRequest.getName())) {
            return ResponseEntity.badRequest().body("Name đã tồn tại");
        }
        if (dynamiccontactRepository.findById(id).isPresent()) {
            dynamiccontact products = dynamiccontactRequest.toEntity();
            products.setId(id);
            dynamiccontactRepository.save(products);
            return ResponseEntity.ok("Update thành công ");
        } else {
            return ResponseEntity.badRequest().body("Không tìm thấy id cần update");
        }
    }


}
