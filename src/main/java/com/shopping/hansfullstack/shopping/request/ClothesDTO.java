package com.shopping.hansfullstack.shopping.request;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClothesDTO {

    private String name;

    private String category;

    private String brand;

    private String detailSize;

    private Long id;

}
