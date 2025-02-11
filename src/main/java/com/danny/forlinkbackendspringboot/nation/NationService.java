package com.danny.forlinkbackendspringboot.nation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NationService {
    private final NationReader nationReader;
    private final NationStore nationStore;
    private final NationMapper nationMapper;

    @Transactional
    public NationResponse save(NationRequest request) {
        Nation nation = nationMapper.toEntity(request);
        return nationMapper.toResponse(nationStore.save(nation));
    }

    @Transactional(readOnly = true)
    public List<NationResponse> findAllByUseYnTrue() {
        List<Nation> nationList = nationReader.findAllByUseYnTrue();
        return nationList.stream()
                .map(nationMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public NationResponse findById(Integer nationId) {
        Nation nation = nationReader.findById(nationId);
        return nationMapper.toResponse(nation);
    }

    @Transactional
    public NationResponse update(Integer nationId, NationRequest request) {
        Nation nation = nationReader.findById(nationId);
        nation.update(request);
        nationStore.save(nation);
        return nationMapper.toResponse(nation);
    }

    @Transactional
    public Integer delete(Integer nationId) {
        Nation nation = nationReader.findById(nationId);
        nation.updateUseYn();
        return nationId;
    }
}
