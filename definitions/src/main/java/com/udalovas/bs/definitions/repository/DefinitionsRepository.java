package com.udalovas.bs.definitions.repository;

import com.udalovas.bs.definitions.model.Definition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefinitionsRepository extends CrudRepository<Definition, String> {

}
