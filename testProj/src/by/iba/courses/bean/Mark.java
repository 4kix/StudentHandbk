package by.iba.courses.bean;

public class Mark {

		private int id;
		private int studyId;
		private int studentId;
		private String date;
		private int professorId;
		private int mark;
		private String comments;
		
		public int getStudentId() {
			return studentId;
		}
		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getStudyId() {
			return studyId;
		}
		public void setStudyId(int studyId) {
			this.studyId = studyId;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getProfessorId() {
			return professorId;
		}
		public void setProfessorId(int professorId) {
			this.professorId = professorId;
		}
		public int getMark() {
			return mark;
		}
		public void setMark(int mark) {
			this.mark = mark;
		}
		public String getComments() {
			return comments;
		}
		public void setComments(String comments) {
			this.comments = comments;
		}
		
		
}
