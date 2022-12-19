package com.example.helloworldspring.ch6.dao;

import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import com.example.helloworldspring.ch6.entities.Singer;

public class PlainSingerDao implements SingerDao{

    private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException exception) {
            logger.error("Prblem loading DB dDriver!", exception);
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:h2:file:./data/demo;OLD_INFORMATION_SCHEMA=TRUE;SCHEMA=MUSICDB",
                "sa",
                "password"
        );
    }

    private void closeConnection(Connection connection){
        if(connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException ex) {
            logger.error("Problem closing connection to the database!", ex);
        }
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from singer");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Singer singer = new Singer();
                singer.setId(resultSet.getLong("id"));
                singer.setFirstName(resultSet.getString("first_name"));
                singer.setLastName(resultSet.getString("last_name"));
                singer.setBirthDate(resultSet.getDate("birth_date"));
                result.add(singer);
            }
            statement.close();
        } catch (SQLException exception) {
            logger.error("Problem when executing SELECT!", exception);
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findLastNameById(Long id) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public void insert(Singer singer) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("insert into Singer " +
                            "(first_name, last_name, birth_date) " +
                            "values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, singer.getFirstName());
            statement.setString(2, singer.getLastName());
            statement.setDate(3, singer.getBirthDate());
            statement.execute();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if(generatedKeys.next()) {
                singer.setId(generatedKeys.getLong(1));
            }
            statement.close();
        } catch (SQLException exception) {
            logger.error("Prblem executing INSERT", exception);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from singer where id=?");
            statement.setLong(1, singerId);
            statement.execute();
            statement.close();
        } catch (SQLException exception) {
            logger.error("Prblm executing DELETE", exception);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }
}
