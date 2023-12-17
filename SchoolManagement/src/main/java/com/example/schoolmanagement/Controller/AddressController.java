package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.DOT.AddressDTO;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;
    Logger logger= LoggerFactory.getLogger(AddressController.class);

    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAllAddress());
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody  @Valid AddressDTO addressDTO) {
        logger.info("added Address");
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body("added Address");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id ,@RequestBody @Valid Address address){
        logger.info("update Address");
        addressService.updateAddress(id, address);
        return ResponseEntity.status(HttpStatus.OK).body("update profile");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        logger.info("delete Address");
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete profile");
    }
    }
