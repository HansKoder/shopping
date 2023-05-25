package com.shopping.hansfullstack.shopping.models;

import lombok.*;

@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UpdateStock {

    private Long clothesId;

    private Integer count;

}
