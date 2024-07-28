package com.org.ultralntinct.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.MappedSuperclass;

/**
 * <p>
 * Abstract Model with following time.
 * </p>
 * 
 * @author MinhNgoc
 */
@MappedSuperclass
public abstract class AbstractModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
//    private String createdBy;
    @CreationTimestamp
    private LocalDateTime thoiGianTao;
//    private String updateBy;
    @UpdateTimestamp
    private LocalDateTime thoiGianUpdate;
}
