package com.shopping.hansfullstack.shopping.services;

import com.shopping.hansfullstack.shopping.request.ClothesDTO;
import com.shopping.hansfullstack.shopping.response.ResponseDTO;

public interface ClothesService {

    ResponseDTO getClothesById (Long id);

    ResponseDTO addClothes (ClothesDTO clothesDTO);

    ResponseDTO updateClothes(ClothesDTO updated, Long clothesId);

    ResponseDTO getClothes ();

}
