package com.vivekinc.springboot.learn_jpa_and_hibernate.course.jdbc;

import com.vivekinc.springboot.learn_jpa_and_hibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    public static String INSERT_QUERY =
            """
                INSERT INTO course (id, name, author)
                VALUES(?,?,?);
            """;

    public static String DELETE_QUERY =
            """
                DELETE FROM course
                WHERE id = ?;
            """;

    public static String SELECT_BY_ID_QUERY =
            """
                SELECT *
                FROM course
                WHERE id = ?;
            """;

    public static String SELECT_ALL_QUERY =
            """
                SELECT *
                FROM course;
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(long id) {
        /*
        ResultSet -> Bean => RowMapper =>
        */
        return springJdbcTemplate.queryForObject(SELECT_BY_ID_QUERY, new BeanPropertyRowMapper<>(Course.class), id);

    }
}
