package com.example.ecom.gateway;

import com.example.ecom.dto.ProductDTO;
import com.example.ecom.dto.ProductTitleDTO;
import com.example.ecom.dto.FakeStoreProductResponseDTO;
import com.example.ecom.gateway.api.FakeStoreProductApi;
import com.example.ecom.mappers.GetAllProductsMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;


// @Gateway does not exist so annotate with @Component
@Component
public class FakeStoreProductGateWay implements IProductGateway {

    private final FakeStoreProductApi fakeStoreProductApi;

    private ModelMapper modelMapper;

    public FakeStoreProductGateWay(FakeStoreProductApi fakeStoreProductApi, ModelMapper modelMapper){
        this.fakeStoreProductApi = fakeStoreProductApi;
        this.modelMapper = modelMapper;
    }



    public FakeStoreProductApi getFakeStoreCategoryApi() {
        return fakeStoreProductApi;
    }



    @Override
    public List<ProductTitleDTO> getProductCategory() throws IOException {
        List<FakeStoreProductResponseDTO> response = this.fakeStoreProductApi.getAllFakeProducts().execute().body();
        if(response == null) {
            throw new IOException("Failed to fetch categories from fakestore api");
        }

        /* According to Solid Principle's Single Responsibility Principle your function
                   your function should have a single responsibility to handle that's why we are mapping separately
        * */
        return GetAllProductsMapper.toProductTitleDTO(response);
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        FakeStoreProductResponseDTO responseDTO = this.fakeStoreProductApi.getFakeProductById(id).execute().body();
        if(responseDTO == null) {
            throw new IOException("Product Not Found");
        }
        return modelMapper.map(responseDTO, ProductDTO.class);
    }
}
