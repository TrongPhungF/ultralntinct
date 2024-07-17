package com.org.ultralntinct.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p>
 * Abstract Model with following time.
 * </p>
 * 
 * @author MinhNgoc
 */
@Data
@AllArgsConstructor
public abstract class AbstractModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String createdBy;
    private LocalDateTime createdDateBy;
    private String updateBy;
    private LocalDateTime updateDateBy;
}
