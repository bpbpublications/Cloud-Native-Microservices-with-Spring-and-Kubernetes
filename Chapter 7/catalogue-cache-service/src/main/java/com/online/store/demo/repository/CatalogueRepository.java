package com.online.store.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.store.demo.model.Catalogue;
/**
 * @author rasrivastava
 *
 */
@Repository
public interface CatalogueRepository extends JpaRepository <Catalogue, Long> {}
