package com.ara.onetomany.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ara.onetomany.model.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja,Long> {
	List<Ninja>findAll();
}
