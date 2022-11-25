package org.jbp.csc611.mc01.repository;

import org.jbp.csc611.mc01.repository.entity.Email;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends CrudRepository<Email, Long> {
}