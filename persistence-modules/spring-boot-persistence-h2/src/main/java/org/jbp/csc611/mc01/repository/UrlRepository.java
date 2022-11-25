package org.jbp.csc611.mc01.repository;

import org.jbp.csc611.mc01.repository.entity.Url;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends CrudRepository<Url, Long> {
    long countLongByStatus(String status);
}