package com.example.ecom.gateway;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductTitleDTO;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

public class FakeStoreRestTemplateGateway implements IProductGateway{

    private final RestTemplate restTemplate;

    public FakeStoreRestTemplateGateway(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public List<ProductTitleDTO> getProductCategory() throws IOException {

        return List.of();
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        return null;
    }
}
