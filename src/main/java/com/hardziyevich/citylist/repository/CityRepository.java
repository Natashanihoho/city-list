package com.hardziyevich.citylist.repository;

import com.hardziyevich.citylist.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByNameContainsIgnoreCase(String name);
}
