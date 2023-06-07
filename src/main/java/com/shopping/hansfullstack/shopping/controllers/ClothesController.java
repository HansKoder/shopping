package com.shopping.hansfullstack.shopping.controllers;

import com.shopping.hansfullstack.shopping.exceptions.ErrorResponse;
import com.shopping.hansfullstack.shopping.exceptions.NoSuchClothesException;
import com.shopping.hansfullstack.shopping.repositories.ClothesRepository;
import com.shopping.hansfullstack.shopping.request.ClothesDTO;
import com.shopping.hansfullstack.shopping.response.ResponseDTO;
import com.shopping.hansfullstack.shopping.services.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/clothes")
public class ClothesController {

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private ClothesService clothesService;

    @PostMapping("/")
    public ResponseDTO addClothes (@RequestBody ClothesDTO clothesDTO) {
        System.out.println(clothesDTO.getBrand());
        System.out.println(clothesDTO.getDetailSize());
        System.out.println(clothesDTO);

        return clothesService.addClothes(clothesDTO);
    }

    @PutMapping("/{id}")
    public ResponseDTO updateClothes (@RequestBody ClothesDTO updated, @PathVariable Long id) {
        return clothesService.updateClothes(updated, id);
    }

    @GetMapping("/{id}")
    public ResponseDTO getClothesById (@PathVariable Long id) {
        return clothesService.getClothesById(id);
    }

    @GetMapping("/")
    public ResponseDTO getAllClothes () {
        return clothesService.getClothes();
    }

    @ExceptionHandler(value = NoSuchClothesException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNoSuchClothesException (NoSuchClothesException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

}
