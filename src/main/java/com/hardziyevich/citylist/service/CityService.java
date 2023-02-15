package com.hardziyevich.citylist.service;

import com.hardziyevich.citylist.dto.CityReadDto;
import com.hardziyevich.citylist.dto.CityUpdateDto;
import com.hardziyevich.citylist.exception.EntityNotFoundException;
import com.hardziyevich.citylist.mapper.CityMapper;
import com.hardziyevich.citylist.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public List<CityReadDto> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable)
                .stream()
                .map(cityMapper::mapToCityDto)
                .collect(toList());
    }

    public CityReadDto findByName(String name) {
        return cityRepository.findByNameIgnoreCase(name)
                .map(cityMapper::mapToCityDto)
                .orElseThrow(() -> new EntityNotFoundException("City is not found by name: " + name));
    }

    @Transactional
    public CityReadDto update(Long id, CityUpdateDto cityUpdateDto) {
        return cityRepository.findById(id)
                .map(city -> cityMapper.update(city, cityUpdateDto))
                .map(cityMapper::mapToCityDto)
                .orElseThrow(() -> new EntityNotFoundException("City is not found by id: " + id));
    }
}
