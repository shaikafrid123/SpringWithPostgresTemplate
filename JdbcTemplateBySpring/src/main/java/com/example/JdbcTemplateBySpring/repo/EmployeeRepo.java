package com.example.JdbcTemplateBySpring.repo;

import com.example.JdbcTemplateBySpring.model.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

@Repository
public class EmployeeRepo {

    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  void save(EmployeeInfo e){
        String query="insert into EmployeeInfo(id,name,salary) values (?,?,?)";
        jdbcTemplate.update(query,e.getId(),e.getName(),e.getSalary());
    }
    public  List<EmployeeInfo> employeeInfoList(){

        String query="select * from EmployeeInfo";
        RowMapper<EmployeeInfo> rowMapper=new RowMapper<EmployeeInfo>() {
            @Override
            public EmployeeInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                EmployeeInfo employeeInfo=new EmployeeInfo();
                employeeInfo.setId(rs.getInt("id"));
                employeeInfo.setName(rs.getString("name"));
                employeeInfo.setSalary(rs.getInt("salary"));
                return employeeInfo;
            }
        };
//        List<EmployeeInfo> employeeInfo=new ArrayList<>();
        return  jdbcTemplate.query(query,rowMapper);
    }
}
