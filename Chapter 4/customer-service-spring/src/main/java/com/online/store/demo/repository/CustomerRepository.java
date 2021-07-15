package com.online.store.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.online.store.demo.model.Customer;
/**
 * @author rasrivastava
 *
 */

@RepositoryRestResource (collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends JpaRepository <Customer, Long> {
}
