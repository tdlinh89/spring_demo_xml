package fpt.fa.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fpt.fa.entities.KhoaHoc;

@Repository
public interface KhoaHocRepository extends CrudRepository<KhoaHoc, String>{
	@Query("select kh.maKhoa from KhoaHoc kh")
	public List<String> findAllMaKhoa();
	
	public List<KhoaHoc> findByTenKhoaContaining(String tenKhoa);
	
	@Query("select s.khoaHocs from Student s where s.lopHoc.maLop = :maLop")
	public Set<KhoaHoc> getAllKhoaHocByLopHoc(@Param("maLop") String maLop);

}
