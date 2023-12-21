package fpt.fa.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "KhoaHoc")
public class KhoaHoc {
	@Id
	@Column(name = "ma_khoa")
	private String maKhoa;
	@Column(name = "ten_khoa", columnDefinition = "nvarchar(100)")
	private String tenKhoa;
	@Column(name = "hoc_phi")
	private float hocPhi;
	
	@ManyToMany(mappedBy = "khoaHocs")
	private List<Student> students;
	
	public String getMaKhoa() {
		return maKhoa;
	}
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public float getHocPhi() {
		return hocPhi;
	}
	public void setHocPhi(float hocPhi) {
		this.hocPhi = hocPhi;
	}
}
