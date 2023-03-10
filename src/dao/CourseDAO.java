package dao;

import bean.Course;
/**
 * User;s CourseDao interface
 */
public interface CourseDAO {

    //link to databse 
    Object[][] getCourseArrayList();

    //display attributes
    Course getCourseById(int id);

    void changeCourse(Course newCourse);

    void deleteCourseById(int id);

    boolean addCourse(Course course);

    boolean isExists(String name);
}
