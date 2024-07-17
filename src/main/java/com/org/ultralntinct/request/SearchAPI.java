package com.org.ultralntinct.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public abstract class SearchAPI {
    private Integer pageNumber;
    private Integer pageSize;
    private String sortField;
    private String sortDirection;
}
