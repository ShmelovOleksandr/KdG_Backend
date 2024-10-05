package be.kdg.prog6.boundedcontextWarehouse.config;

import be.kdg.prog6.boundedcontextWarehouse.adapter.out.converter.WarehouseDomainToJpaConverter;
import be.kdg.prog6.boundedcontextWarehouse.adapter.out.converter.WarehouseJpaToDomainConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new WarehouseJpaToDomainConverter());
        modelMapper.addConverter(new WarehouseDomainToJpaConverter());
        return modelMapper;
    }
}
