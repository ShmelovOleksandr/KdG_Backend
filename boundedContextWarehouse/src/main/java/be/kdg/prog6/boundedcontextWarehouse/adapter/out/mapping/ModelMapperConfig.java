package be.kdg.prog6.boundedcontextWarehouse.adapter.out.mapping;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.mapping.converters.WarehouseDomainToJpaConverter;
import be.kdg.prog6.boundedcontextWarehouse.adapter.out.mapping.converters.WarehouseJpaToDomainConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new WarehouseJpaToDomainConverter());
        modelMapper.addConverter(new WarehouseDomainToJpaConverter());
        return modelMapper;
    }
}
