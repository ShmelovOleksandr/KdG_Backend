package be.kdg.prog6.boundedcontextLandside.adapter.out.mapping;

import be.kdg.prog6.boundedcontextLandside.adapter.out.mapping.converters.WarehouseDomainToJpaConverter;
import be.kdg.prog6.boundedcontextLandside.adapter.out.mapping.converters.WarehouseJpaToDomainConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new WarehouseDomainToJpaConverter());
        modelMapper.addConverter(new WarehouseJpaToDomainConverter());
        return modelMapper;
    }
}
