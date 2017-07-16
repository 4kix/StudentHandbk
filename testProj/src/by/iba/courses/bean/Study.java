package by.iba.courses.bean;

public class Study {

		private int id;
		private String name;
		private int hours;
		private int professorId;
		private double avgMark;
		
		public Study() {
			super();
		}
		
		public Study(int id, String name, int hours, int professorId) {
			super();
			this.id = id;
			this.name = name;
			this.hours = hours;
			this.professorId = professorId;
			this.avgMark = avgMark;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getHours() {
			return hours;
		}
		public void setHours(int hours) {
			this.hours = hours;
		}
		public int getProfessorId() {
			return professorId;
		}
		public void setProfessorId(int professorId) {
			this.professorId = professorId;
		}
		public double getAvgMark() {
			return avgMark;
		}
		public void setAvgMark(double avgMark) {
			this.avgMark = avgMark;
		}
		
		
}
