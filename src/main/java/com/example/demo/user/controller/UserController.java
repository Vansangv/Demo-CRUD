package com.example.demo.user.controller;

import com.example.demo.dynamiccontact.etity.dynamiccontact;
import com.example.demo.dynamiccontact.service.dynamiccontactRequest;
import com.example.demo.user.etity.User;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.UserReponse;
import com.example.demo.user.service.UsertRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/getAll")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        List<UserReponse> list = new ArrayList<>();
        userRepository.findAll().forEach(c -> list.add(c.toResponse()));
        return ResponseEntity.ok(list);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return ResponseEntity.ok("Xóa thành công");
        }else {
            return ResponseEntity.badRequest().body("Không tìm thấy id cần xóa");
        }
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody UsertRequest usertRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder mess = new StringBuilder();
            bindingResult.getAllErrors().forEach(error -> mess.append(error.getDefaultMessage()).append("\n"));
            return ResponseEntity.badRequest().body(mess.toString());
        }
        if (userRepository.existsByUsername(usertRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Name đã tồn tại");
        }

        User products = usertRequest.toEntity();
        userRepository.save(products);
        return ResponseEntity.ok("thêm thành công");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody UsertRequest usertRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
        }
        if (userRepository.existsByUsername(usertRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Name đã tồn tại");
        }
        if (userRepository.findById(id).isPresent()) {
            User products = usertRequest.toEntity();
            products.setId(id);
            userRepository.save(products);
            return ResponseEntity.ok("Update thành công ");
        } else {
            return ResponseEntity.badRequest().body("Không tìm thấy id cần update");
        }


}
