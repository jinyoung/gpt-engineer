package com.ordermanagement.interfaces;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {
    private String 메뉴;
    private String 배송주소;
}