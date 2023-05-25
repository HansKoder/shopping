package com.shopping.hansfullstack.shopping.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class DetailPurchaseDTO {

    private Long clothesId;

    private Integer count;

    private Double pricePerUnit;

    private Double total;

}
