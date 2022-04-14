package rest.config;

import com.virtuslab.internship.product.Product;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rest.entity.ProductEntity;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mapper = new ModelMapper();

        mapper.addMappings(new PropertyMap<ProductEntity, Product>() {
            @Override
            protected void configure() {

            }
        });

        mapper.addMappings(new PropertyMap<Product, ProductEntity>() {
            @Override
            protected void configure() {

            }
        });

        return mapper;
    }

}
