package com.shubhambharti.productservice.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
@Data
public class Category  extends BaseModel{

    private String name;

}
