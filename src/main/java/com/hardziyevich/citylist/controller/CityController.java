package com.hardziyevich.citylist.controller;

import com.hardziyevich.citylist.dto.CityReadDto;
import com.hardziyevich.citylist.dto.CityUpdateDto;
import com.hardziyevich.citylist.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/cities")
@Validated
public class CityController {

    private final CityService cityService;

    @GetMapping
    public ResponseEntity<List<CityReadDto>> findAll(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok(cityService.findAll(pageable));
    }

    @GetMapping("/{name}")
    public ResponseEntity<CityReadDto> findByName(@PathVariable String name) {
        return ResponseEntity.ok(cityService.findByName(name));
    }

    @PreAuthorize("hasRole('ROLE_ALLOW_EDIT')")
    @PatchMapping
    public ResponseEntity<CityReadDto> update(
            @RequestParam @Positive Long id, @RequestBody @NotNull CityUpdateDto cityUpdateDto
    ) {
        return ResponseEntity.ok(cityService.update(id, cityUpdateDto));
    }
}
