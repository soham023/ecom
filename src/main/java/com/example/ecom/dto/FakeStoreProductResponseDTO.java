package com.example.ecom.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FakeStoreProductResponseDTO {

    private int id;

    private String title;

    private double price;

    private String description;

    private String category;

    private String image;

    private RatingDTO rating;
}
