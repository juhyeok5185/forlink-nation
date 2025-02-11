package com.danny.forlinkbackendspringboot.nation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NationMapper {
    private final ModelMapper modelMapper;

    public Nation toEntity(NationRequest request) {
        return modelMapper.map(request, Nation.class);
    }

    public NationResponse toResponse(Nation nation) {
        return modelMapper.map(nation, NationResponse.class);
    }
}
