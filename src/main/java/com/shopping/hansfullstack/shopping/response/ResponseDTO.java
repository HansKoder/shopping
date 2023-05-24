package com.shopping.hansfullstack.shopping.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDTO {

    private HttpStatus status;

    private String message;

    private String error;

    private String detailError;

    private Object data;

}
