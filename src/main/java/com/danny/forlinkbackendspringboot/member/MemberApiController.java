package com.danny.forlinkbackendspringboot.member;

import com.danny.forlinkbackendspringboot.common.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<ApiResponse<MemberResponse>> save(@RequestBody @Valid MemberRequest request) {
        return ResponseEntity.ok(new ApiResponse<>(memberService.save(request)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody @Valid MemberAuthRequest request) {
        String token = memberService.login(request);
        return ResponseEntity.ok(new ApiResponse<>(token));
    }
}
