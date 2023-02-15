package com.hardziyevich.citylist.mapper;

import com.hardziyevich.citylist.dto.CityReadDto;
import com.hardziyevich.citylist.dto.CityUpdateDto;
import com.hardziyevich.citylist.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper
public interface CityMapper {

    CityReadDto mapToCityDto(City city);

    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "imagePath", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    City update(@MappingTarget City city, CityUpdateDto cityUpdateDto);
}
