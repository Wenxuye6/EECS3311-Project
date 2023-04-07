package dao.impl;

import bean.Course;
import dao.BaseDAO;
import dao.CourseDAO;

import java.util.List;

/**
 * Welcome to CourseDAOImpl class, this class extends BaseDAO<Course>
 */
public class CourseDAOImpl extends BaseDAO<Course> implements CourseDAO {

    @Override
    public Object[][] getCourseArrayList() {
        String sql = "select * from t_course";
        List<Object[]> l = getArrayList(sql);
        Object[][] list = new Object[l.size()][4];
        int i = 0;
        for (Object[] o : l) {
            list[i++] = o;
        }
        return list;
    }

    @Override
    public List<Course> getCourseList() {
        String sql = "select * from t_course";
        return getBeanList(sql);
    }

    @Override
    public Course getCourseById(int id) {
        String sql = "select * from `t_course` where `courseId`=?";
        return getBean(sql, id);
    }

    @Override
    public void changeCourse(Course newCourse) {
        String sql = "update `t_course` set `courseName`=?,`price`=?,`benefit`=? where `courseId`=?";
        update(sql, newCourse.getCourseName(), newCourse.getPrice(), newCourse.getBenefit(), newCourse.getCourseId());
    }

    @Override
    public void deleteCourseById(int id) {
        String sql = "delete from `t_course` where `courseId`=?";
        update(sql, id);
    }

    @Override
    public boolean addCourse(Course course) {
        if (isExists(course.getCourseName())) {
            return false;
        }
        String sql = "insert into `t_course`(`courseName`,`price`,`benefit`)values(?,?,?)";
        return update(sql, course.getCourseName(), course.getPrice(), course.getBenefit()) > 0;
    }

    @Override
    public boolean isExists(String name) {
        String sql = "select * from `t_course` where `courseName`=?";
        return getBean(sql, name) != null;
    }
}
