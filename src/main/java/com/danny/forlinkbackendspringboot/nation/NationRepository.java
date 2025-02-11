package com.danny.forlinkbackendspringboot.nation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NationRepository extends JpaRepository<Nation , Integer> {
    List<Nation> findAllByUseYnTrue();
}
