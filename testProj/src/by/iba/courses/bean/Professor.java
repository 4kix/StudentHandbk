package by.iba.courses.bean;

public class Professor {
	private int id;
	private String firstName;
	private String secondName;
	private String fatherName;
	private String BirthDate;
	private Double AvgMark;
	
	public Double getAvgMark() {
		return AvgMark;
	}
	public void setAvgMark(Double avgMark) {
		AvgMark = avgMark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getBirthDate() {
		return BirthDate;
	}
	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}
	
	
}
