package com.shopping.hansfullstack.shopping.services.imp;

import com.shopping.hansfullstack.shopping.entities.Clothes;
import com.shopping.hansfullstack.shopping.exceptions.NoSuchClothesException;
import com.shopping.hansfullstack.shopping.mappers.ClothesMapper;
import com.shopping.hansfullstack.shopping.repositories.ClothesRepository;
import com.shopping.hansfullstack.shopping.request.ClothesDTO;
import com.shopping.hansfullstack.shopping.response.ResponseDTO;
import com.shopping.hansfullstack.shopping.services.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class ClothesServiceImpl implements ClothesService {

    @Autowired
    private ClothesRepository clothesRepository;

    @Override
    public ResponseDTO getClothesById(Long id) {
        Clothes clothes = clothesRepository
                .findById(id).orElseThrow(() -> new NoSuchElementException("No Clothes present with ID " + id));

        return ResponseDTO.builder().data(clothes).status(HttpStatus.OK).build();
    }

    @Override
    public ResponseDTO addClothes(ClothesDTO clothesDTO) {
        Clothes clothes = clothesRepository.save(ClothesMapper.INSTANCE.DTOTOEntity(clothesDTO));

        return ResponseDTO.builder()
                .status(HttpStatus.CREATED)
                .message("Created!!")
                .data(ClothesMapper.INSTANCE.entityToDTO(clothes))
                .build();
    }

    @Override
    public ResponseDTO updateClothes(ClothesDTO updated, Long clothesId) {
        Clothes clothes = clothesRepository.findById(clothesId)
                .orElseThrow(() -> new NoSuchClothesException("No Such Clothes with the ID " + clothesId));

        clothes.setBrand(updated.getBrand());

        ClothesDTO alreadyUpdated = ClothesMapper.INSTANCE.entityToDTO(clothesRepository.save(clothes));

        return ResponseDTO.builder()
                .status(HttpStatus.BAD_REQUEST)
                .data(alreadyUpdated).build();
    }

    @Override
    public ResponseDTO getClothes() {
        return ResponseDTO
                .builder()
                .data(clothesRepository.findAll().stream().map(c -> ClothesMapper.INSTANCE.entityToDTO(c)))
                .build();
    }
}