package com.shopping.hansfullstack.shopping.mappers;

import com.shopping.hansfullstack.shopping.entities.Clothes;
import com.shopping.hansfullstack.shopping.request.ClothesDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClothesMapper {

    ClothesMapper INSTANCE = Mappers.getMapper(ClothesMapper.class);
    ClothesDTO entityToDTO(Clothes entity);


    Clothes DTOTOEntity(ClothesDTO entity);

}
