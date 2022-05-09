package ru.gb.gbapi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.gb.gbapi.category.api.CategoryGateway;
import ru.gb.gbapi.manufacturer.api.ManufacturerGateway;
import ru.gb.gbapi.product.api.ProductGateway;

@Configuration
@EnableFeignClients
@EnableConfigurationProperties(GbApiProperties.class)
@RequiredArgsConstructor
@Import(value = {FeignClientFactory.class})
public class FeignConfig {

    private final GbApiProperties gbApiProperties;
    private final FeignClientFactory feignClientFactory;

    @Bean(name = "categoryGateway")
    public CategoryGateway categoryGateway() {
        return feignClientFactory.newFeignClient(CategoryGateway.class,
                gbApiProperties.getEndpoint().getCategoryInternalUrl());
    }

    @Bean(name = "manufacturerGateway")
    public ManufacturerGateway manufacturerGateway() {
        return feignClientFactory.newFeignClient(ManufacturerGateway.class,
                gbApiProperties.getEndpoint().getManufacturerInternalUrl());
    }

    @Bean(name = "productGateway")
    public ProductGateway productGateway() {
        return feignClientFactory.newFeignClient(ProductGateway.class,
                gbApiProperties.getEndpoint().getProductInternalUrl());
    }

}
