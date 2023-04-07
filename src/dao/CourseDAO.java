package dao;

import bean.Course;

import java.util.List;

/**
 * Users CourseDao interface
 */
public interface CourseDAO {

    //link to databse
    Object[][] getCourseArrayList();

    List<Course> getCourseList();

    //display attributes
    Course getCourseById(int id);

    void changeCourse(Course newCourse);

    void deleteCourseById(int id);

    boolean addCourse(Course course);

    boolean isExists(String name);
}
