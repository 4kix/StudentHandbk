package by.iba.courses.dao;


import java.util.List;

import by.iba.courses.bean.Professor;

public interface ProfessorDAO {

    public Professor add(Professor professor) throws DAOException;

    public Professor read(int key) throws DAOException;

    public void update(Professor professor);

    public void delete(Professor professor);
    
    public List<Professor> getAll() throws DAOException;

	public void recalcAvgMark() throws DAOException;
}
