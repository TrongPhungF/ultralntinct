package com.org.ultralntinct.request;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * <p>
 * The Class SearchAPI.
 * </p>
 *
 * @author MinhNgoc
 */
@Data
@RequiredArgsConstructor
public abstract class SearchAPI {

    /** The page number. */
    private Integer pageNumber;

    /** The page size. */
    private Integer pageSize;

    /** The sort field. */
    private String sortField;

    /** The sort direction. */
    private String sortDirection;
}
