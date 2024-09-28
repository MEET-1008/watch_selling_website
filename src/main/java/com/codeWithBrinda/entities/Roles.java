package com.codeWithBrinda.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Data
public class Roles {

    @Id
    public int id ;
    public String name ;


}