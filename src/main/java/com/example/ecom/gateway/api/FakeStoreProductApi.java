package com.example.ecom.gateway.api;

import com.example.ecom.dto.FakeStoreProductResponseDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;


@Component
public interface FakeStoreProductApi {

    // call object is used in retrofit for the admitting the response type.
    @GET("products")
    Call<List<FakeStoreProductResponseDTO>> getAllFakeProducts() throws IOException;

    // wiring through retrofit
    @GET("products/{id}")
    Call<FakeStoreProductResponseDTO> getFakeProductById(@Path("id") Long id) throws IOException;
}
