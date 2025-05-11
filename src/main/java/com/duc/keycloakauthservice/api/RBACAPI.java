package com.duc.keycloakauthservice.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rbac")
public class RBACAPI {
    @GetMapping("/merge-role")
    @PreAuthorize("hasRole('MERGE')")
    public ResponseEntity<?> testForMergeRole() {
        System.out.println("SOMETHING ");
        return ResponseEntity.status(HttpStatus.OK).body("I HAVE ACCESS to MERGE ROLE");
    }
}
