package com.springboot.restapi.onetomany;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VechilesRepository extends JpaRepository<Vechiles,Long>{

}
