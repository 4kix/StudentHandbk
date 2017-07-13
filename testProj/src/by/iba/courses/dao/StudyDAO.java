package by.iba.courses.dao;


import java.util.List;

import by.iba.courses.bean.Study;


public interface StudyDAO {
	
    public Study add(Study study) throws DAOException;

    public Study read(int key) throws DAOException;

    public void update(Study study);

    public void delete(Study study);
    
    public List<Study> getAll() throws DAOException;

	public void recalcAvgMark() throws DAOException;
}
