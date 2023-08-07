package com.ecommerce.miniProject.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private long id;
    private String category;
    private String title;
    private  String description;
    private  Double price;
    private boolean active;
    private  String  image;


    public boolean getActive() {
        return active;
    }
}
