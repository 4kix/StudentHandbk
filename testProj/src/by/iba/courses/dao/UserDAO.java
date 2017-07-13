package by.iba.courses.dao;

import java.util.List;
import by.iba.courses.bean.User;

public interface UserDAO {

    public String add(User user) throws DAOException;

    public User read(String key) throws DAOException;

    public void update(String id, User user) throws DAOException;

    public void delete(String id, User user) throws DAOException;
    
    public User authCheck(String login, String password) throws DAOException;

    public List<User> getAll() throws DAOException;
    
}
