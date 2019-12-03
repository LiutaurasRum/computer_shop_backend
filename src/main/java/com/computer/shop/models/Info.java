package com.computer.shop.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Table(name="info")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class Info implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank
    private String name;

    @NotBlank
    private String model;

    private int count;
    @NotBlank
    private  String type;

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public String getType() {
        return type;
    }

    public String getModel() {
        return model;
    }
}
