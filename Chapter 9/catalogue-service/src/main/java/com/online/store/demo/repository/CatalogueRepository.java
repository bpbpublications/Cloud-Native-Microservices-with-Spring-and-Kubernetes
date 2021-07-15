package com.online.store.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.online.store.demo.model.Catalogue;
/**
 * @author rasrivastava
 *
 */

@RepositoryRestResource (collectionResourceRel = "catalogues", path = "catalogues")
public interface CatalogueRepository extends JpaRepository <Catalogue, Long> {
}
