package com.danny.forlinkbackendspringboot.nation;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NationService {
    private final NationReader nationReader;
    private final NationStore nationStore;
    private final NationFactory nationFactory;
    private final ModelMapper modelMapper;

    @Transactional
    public NationResponse save(NationRequest request) {
        Nation nation = nationStore.save(nationFactory.createEntity(request));
        return modelMapper.map(nation, NationResponse.class);
    }

    @Transactional(readOnly = true)
    public List<NationResponse> findAll() {
        return nationReader.findAll().stream()
                .map(nationFactory::createResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public NationResponse findById(Integer nationId) {
        return nationFactory.createResponse(nationReader.findById(nationId));
    }

    @Transactional
    public NationResponse update(Integer nationId, NationRequest request) {
        Nation nation = nationReader.findById(nationId);
        nation.update(request);
        nationStore.save(nation);
        return modelMapper.map(nation, NationResponse.class);
    }

    @Transactional
    public Integer delete(Integer nationId) {
        Nation nation = nationReader.findById(nationId);
        nationStore.delete(nation);
        return nationId;
    }
}
