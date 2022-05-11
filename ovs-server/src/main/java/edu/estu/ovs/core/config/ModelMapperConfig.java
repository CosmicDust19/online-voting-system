package edu.estu.ovs.core.config;

import edu.estu.ovs.models.dtos.CandidateCrDto;
import edu.estu.ovs.models.entities.Candidate;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        modelMapper.addMappings(candCrDtoToCand);
        return modelMapper;
    }

    private final PropertyMap<CandidateCrDto, Candidate> candCrDtoToCand = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getAddress(), destination.getAddress());
        }
    };

}
