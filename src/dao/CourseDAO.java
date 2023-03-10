package dao;

import bean.Course;

public interface CourseDAO {

    Object[][] getCourseArrayList();

    Course getCourseById(int id);

    void changeCourse(Course newCourse);

    void deleteCourseById(int id);

    boolean addCourse(Course course);

    boolean isExists(String name);
}
