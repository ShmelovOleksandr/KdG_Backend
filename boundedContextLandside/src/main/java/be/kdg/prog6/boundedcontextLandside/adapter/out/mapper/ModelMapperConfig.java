package be.kdg.prog6.boundedcontextLandside.adapter.out.mapper;

import be.kdg.prog6.boundedcontextLandside.adapter.out.mapper.converters.*;
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
        modelMapper.addConverter(new AppointmentManagerDomainToJpaConverter());
        modelMapper.addConverter(new AppointmentManagerJpaToDomainConverter());
        return modelMapper;
    }
}
