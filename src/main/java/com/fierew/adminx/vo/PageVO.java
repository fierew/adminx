package com.fierew.adminx.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<E> {
    private Long total;
    private List<E> lists;
}
