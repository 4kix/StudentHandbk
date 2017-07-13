package by.iba.courses.dao;


import java.util.List;

import by.iba.courses.bean.Mark;


public interface MarkDAO {
	
    public Mark add(Mark mark) throws DAOException;

    public Mark read(int key) throws DAOException;

    public void update(Mark mark);

    public void delete(Mark mark);
    
    public List<Mark> getAll() throws DAOException;
}
