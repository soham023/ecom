package com.example.ecom.configuration;

import com.example.ecom.gateway.api.FakeStoreProductApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

//    @Value("${fakestore.api.base-url}")
//    private String fakeStoreBaseUrl;

    @Bean
    public Retrofit retrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    // The moment you identify this method with @Bean, technically you are telling to Springboot that whenever you want to create an object of this particular class "FakeStoreCategoryApi" , refer this method
    // This method is where you are going to create an object of a particular class.
    // convention -> returntype should be same as interface
    @Bean
    public FakeStoreProductApi fakeStoreCategoryApi(Retrofit retrofit){
        //but for creating the object of this we need a retrofit instance
        return retrofit.create(FakeStoreProductApi.class);
    }
}
