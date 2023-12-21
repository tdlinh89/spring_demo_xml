package fpt.fa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "LopHoc")
public class LopHoc {
	@Id
	@Column(name = "ma_lop")
	private String maLop;
	@Column(name = "ten_lop", columnDefinition = "nvarchar(100)")
	private String tenLop;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ngay_bat_dau")
	private Date ngayBatDau;
	
	@OneToMany(mappedBy = "lopHoc")
	private List<Student> students;
	
	public String getMaLop() {
		return maLop;
	}
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public Date getNgayBatDau() {
		return ngayBatDau;
	}
	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
