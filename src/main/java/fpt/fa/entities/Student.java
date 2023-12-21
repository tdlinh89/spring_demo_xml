package fpt.fa.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import fpt.fa.validated.Phone;

@Entity
@Table(name = "Student")
public class Student {
	@Id
	@Pattern(regexp = "SV*[0-9]{4}$")
	private String id;
	
	@Column(columnDefinition = "nvarchar(50)", nullable = true)
	@Length(min = 4, message = "{error.name}")
	private String name;

//	@Min(value = 18, message = "Tuổi không được nhỏ hơn {value}")
	@Min(value = 18, message = "{error.age}")
	private int age;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String address;
	
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	private Date birthday;
	
	@ManyToOne
	@JoinColumn(name = "ma_lop", nullable = false)
	private LopHoc lopHoc;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "Student_KhoaHoc", joinColumns = @JoinColumn(name = "student_id"), 
				inverseJoinColumns = @JoinColumn(name = "ma_khoa"))
	private List<KhoaHoc> khoaHocs;
	
	@Phone
	private String phoneNumber;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String id, String name, int age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", birthday="
				+ birthday + "]";
	}

	public LopHoc getLopHoc() {
		return lopHoc;
	}

	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}

	public List<KhoaHoc> getKhoaHocs() {
		return khoaHocs;
	}

	public void setKhoaHocs(List<KhoaHoc> khoaHocs) {
		this.khoaHocs = khoaHocs;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
