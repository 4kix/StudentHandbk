package by.iba.courses.dao;

import java.util.List;

import by.iba.courses.bean.Student;

public interface StudentDAO {

	
    public Student add(Student student) throws DAOException;

    public Student read(int key) throws DAOException;

    public void update(Student student);

    public void delete(Student student);
    
    public List<Student> getAll() throws DAOException;
    
    public void recalcAvgMark() throws DAOException;
}
