package by.iba.courses.dao;


import java.util.List;

import by.iba.courses.bean.Study;


public interface StudyDAO {
	
    public String add(Study study) throws DAOException;

    public Study read(int key) throws DAOException;

    public void update(Study study) throws DAOException;

    public void delete(int id) throws DAOException;
    
    public List<Study> getAll() throws DAOException;

	public void recalcAvgMark() throws DAOException;
}
