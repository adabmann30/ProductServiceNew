package com.dabman.WebAPI.DTOs;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class FSPDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String image;
    private String category;
}
