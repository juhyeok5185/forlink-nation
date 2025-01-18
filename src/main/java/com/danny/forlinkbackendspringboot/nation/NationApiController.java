package com.danny.forlinkbackendspringboot.nation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nation")
@RequiredArgsConstructor
public class NationApiController {

    @GetMapping
    public void findAll(){
    }

}
