package com.danny.forlinkbackendspringboot.nation;

import com.danny.forlinkbackendspringboot.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nation")
public class NationApiController {

    private final NationService nationService;

    @PostMapping
    private ResponseEntity<ApiResponse<NationResponse>> save(@RequestBody @Valid NationRequest request){
        return ResponseEntity.ok(new ApiResponse<>(nationService.save(request)));
    }

    @GetMapping
    private ResponseEntity<ApiResponse<List<NationResponse>>> findAll(){
        return ResponseEntity.ok(new ApiResponse<>(nationService.findAll()));
    }

    @GetMapping("/{nationId}")
    private ResponseEntity<ApiResponse<NationResponse>> findById(@PathVariable Integer nationId){
        return ResponseEntity.ok(new ApiResponse<>(nationService.findById(nationId)));
    }

    @PatchMapping("/{nationId}")
    private ResponseEntity<ApiResponse<NationResponse>> update(@PathVariable Integer nationId, @RequestBody @Valid NationRequest request){
        return ResponseEntity.ok(new ApiResponse<>(nationService.update(nationId, request)));
    }

    @DeleteMapping("/{nationId}")
    private ResponseEntity<ApiResponse<Integer>> delete(@PathVariable Integer nationId){
        return ResponseEntity.ok(new ApiResponse<>(nationService.delete(nationId)));
    }


}
