package com.fundamentosplatzi.springboot.fundamentos.controller;

import com.fundamentosplatzi.springboot.fundamentos.dto.ResponseServiceDTO;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @ResponseBody
    @GetMapping("/users")
    public ResponseEntity<ResponseServiceDTO> findAll() {
        ResponseEntity<ResponseServiceDTO> response = null;
        List<User> list = null;
        try {
            list = userService.findAll();
            response = new ResponseEntity<ResponseServiceDTO>(new ResponseServiceDTO("0", "OK", null, list), HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<ResponseServiceDTO>(new ResponseServiceDTO("-1", "Error General del servicio", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }


//    @ResponseBody
    @PostMapping("/user")
    public ResponseEntity<ResponseServiceDTO> save(@RequestBody User user) {
        ResponseEntity<ResponseServiceDTO> response = null;
        try {
            User userResp = userService.save(user);
            response = new ResponseEntity<ResponseServiceDTO>(new ResponseServiceDTO("0", "Usuario creado exitosamente", null, userResp ),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            response = new ResponseEntity<ResponseServiceDTO>(new ResponseServiceDTO("-1", "Error General del servicio", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        } return response;
    }

    @ResponseBody
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ResponseServiceDTO> delete(@PathVariable Long id) {
        ResponseEntity<ResponseServiceDTO> response = null;
        try {
            userService.deleteById(id);
            response = new ResponseEntity<ResponseServiceDTO>(new ResponseServiceDTO("0", "Usuario eliminado exitosamente", null, null),
                    HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            response = new ResponseEntity<ResponseServiceDTO>(new ResponseServiceDTO("-1", "Error General del servicio", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @ResponseBody
    @PatchMapping("/user/{id}")
    public ResponseEntity<ResponseServiceDTO> update(@PathVariable Long id, @RequestBody User user) {
        ResponseEntity<ResponseServiceDTO> response = null;
        try {
            User userResp = userService.update(user, id);
            response = new ResponseEntity<ResponseServiceDTO>(new ResponseServiceDTO("0", "Usuario actualizado exitosamente", null,
                    userResp), HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<ResponseServiceDTO>(new ResponseServiceDTO("-1", "Error General del servicio", e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
