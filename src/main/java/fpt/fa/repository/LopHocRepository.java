package fpt.fa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fpt.fa.entities.LopHoc;

@Repository
public interface LopHocRepository extends CrudRepository<LopHoc, String>{

}
