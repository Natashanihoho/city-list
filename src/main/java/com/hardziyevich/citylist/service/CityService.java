package com.hardziyevich.citylist.service;

import com.hardziyevich.citylist.dto.CityReadDto;
import com.hardziyevich.citylist.dto.CityUpdateDto;
import com.hardziyevich.citylist.exception.EntityNotFoundException;
import com.hardziyevich.citylist.mapper.CityMapper;
import com.hardziyevich.citylist.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public Page<CityReadDto> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable)
                .map(cityMapper::mapToCityDto);
    }

    public List<CityReadDto> findAllByName(String name) {
        return cityRepository.findByNameContainsIgnoreCase(name)
                .stream()
                .map(cityMapper::mapToCityDto)
                .toList();
    }

    @Transactional
    public CityReadDto update(Long id, CityUpdateDto cityUpdateDto) {
        return cityRepository.findById(id)
                .map(city -> cityMapper.update(city, cityUpdateDto))
                .map(cityMapper::mapToCityDto)
                .orElseThrow(() -> new EntityNotFoundException("City is not found by id: " + id));
    }
}
