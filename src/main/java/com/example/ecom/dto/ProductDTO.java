package com.example.ecom.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO{
	private String image;
	private Double price;
	private String description;
	private Long id;
	private String title;
	private Long categoryId;
}