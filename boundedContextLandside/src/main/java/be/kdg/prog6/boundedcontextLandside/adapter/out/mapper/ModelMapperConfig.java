package be.kdg.prog6.boundedcontextLandside.adapter.out.mapper;

import be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters.AppointmentDomainToJpaConverter;
import be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters.AppointmentJpaToDomainConverter;
import be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters.WarehouseDomainToJpaConverter;
import be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters.WarehouseJpaToDomainConverter;
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
        modelMapper.addConverter(new AppointmentDomainToJpaConverter());
        modelMapper.addConverter(new AppointmentJpaToDomainConverter());
        return modelMapper;
    }
}
