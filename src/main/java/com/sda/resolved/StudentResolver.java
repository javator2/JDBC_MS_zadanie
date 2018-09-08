package com.sda.resolved;

import com.sda.Database;
import com.sda.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentResolver extends AbstractResolver<Student> {

    private Connection connection = Database.getConnection();

    @Override
    public Student get(int id) {
        return null;
    }

    @Override
    public List<Student> get() {
        List<Student> studentList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String sql = "select * from student";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                int id =resultSet.getInt("id");
                String name = resultSet.getString("name");
                String lastname = resultSet.getString("lastname");
                studentList.add(new Student(id,name,lastname));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
        public boolean delete(int id) throws SQLException {
            String sql = "delete from student where id = " + id;
            Statement statement =null;
            try {
                statement = connection.createStatement();


            } catch (SQLException e) {
                e.printStackTrace();
            } return statement.execute(sql);
        }

    @Override
    public boolean insert(Map<String, String> params) throws SQLException {
        String sql = "insert into student(name,lastname) values ('"+params.get("name")+"', '"+params.get("lastname")+"');";
        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }

    @Override
    public boolean update(int id, Map<String, String> params) throws SQLException {
        String sql = "update student set name = '"+params.get("name")+"', lastname ='"+params.get("lastname")+"' where id ="+id;
        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }
}
