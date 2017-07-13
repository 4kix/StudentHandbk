package by.iba.courses.dao;


import java.util.List;

import by.iba.courses.bean.Group;



public interface GroupDAO {
	
    public Group add(Group group) throws DAOException;

    public Group read(int key) throws DAOException;

    public void update(Group group) throws DAOException;

    public void delete(Group group) throws DAOException;
    
    public List<Group> getAll() throws DAOException;

}
