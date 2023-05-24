package com.shopping.hansfullstack.shopping.request;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
public class AddPurchaseDTO {

   private Long idSupplier;

    private Date date;

    private Double total;

    private String comments;

    private List<DetailPurchaseDTO> items;

}
