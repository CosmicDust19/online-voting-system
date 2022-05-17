package edu.estu.ovs.core.config;

import edu.estu.ovs.models.dtos.*;
import edu.estu.ovs.models.entities.*;
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
        modelMapper.addMappings(voteDtoToVote);
        modelMapper.addMappings(electionDtoToElection);
        modelMapper.addMappings(candidateDtoToCandidate);
        modelMapper.addMappings(userDtoToAdmin);
        modelMapper.addMappings(userDtoToVoter);
        modelMapper.addMappings(certDtoToCert);
        modelMapper.addMappings(schDtoToSch);
        return modelMapper;
    }

    private final PropertyMap<VoteDto, Vote> voteDtoToVote = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getCandidateId(), destination.getCandidate().getUid());
            map(source.getVoterId(), destination.getVoter().getUid());
            map(source.getElectionId(), destination.getElection().getEid());
        }
    };

    private final PropertyMap<ElectionDto, Election> electionDtoToElection = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getCreatorAdminId(), destination.getCreator().getUid());
            map(source.getStartDate(), destination.getStart());
            map(source.getEndDate(), destination.getEnd());
        }
    };

    private final PropertyMap<CandidateDto, Candidate> candidateDtoToCandidate = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getNationalityId(), destination.getNatId());
            map(source.getFirstName(), destination.getFName());
            map(source.getMiddleName(), destination.getMName());
            map(source.getLastName(), destination.getLName());
        }
    };

    private final PropertyMap<UserDto, Admin> userDtoToAdmin = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getFirstName(), destination.getFName());
            map(source.getMiddleName(), destination.getMName());
            map(source.getLastName(), destination.getLName());
        }
    };

    private final PropertyMap<UserDto, Voter> userDtoToVoter = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getFirstName(), destination.getFName());
            map(source.getMiddleName(), destination.getMName());
            map(source.getLastName(), destination.getLName());
        }
    };

    private final PropertyMap<CertificationDto, Certification> certDtoToCert = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getCandidateId(), destination.getCandidate().getUid());
        }
    };

    private final PropertyMap<SchoolDto, School> schDtoToSch = new PropertyMap<>() {
        @Override
        protected void configure() {
            map(source.getCandidateId(), destination.getCandidate().getUid());
        }
    };

}
