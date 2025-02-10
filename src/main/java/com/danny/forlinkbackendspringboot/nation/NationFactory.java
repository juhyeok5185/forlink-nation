package com.danny.forlinkbackendspringboot.nation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NationFactory {
    private final ModelMapper modelMapper;

    public Nation createEntity(NationRequest request) {
        return modelMapper.map(request, Nation.class);
    }

    public NationResponse createResponse(Nation nation) {
        return modelMapper.map(nation, NationResponse.class);
    }
}
