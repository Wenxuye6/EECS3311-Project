import bean.Course;
import bean.Member;
import dao.CourseDAO;
import dao.MemberDAO;
import dao.ScheduleDAO;
import dao.impl.CourseDAOImpl;
import dao.impl.MemberDAOImpl;
import dao.impl.ScheduleDAOImpl;

public class Test {
    //test for search
    @org.junit.Test
    public void testMember() {
        MemberDAO dao = new MemberDAOImpl();
        Object[][] list = dao.getUserArrayList();
        for (Object[] objects : list) {
            for (int j = 0; j < list[0].length; j++) {
                System.out.print(objects[j]);
            }
            System.out.println();
        }
    }

    @org.junit.Test
    public void testCourse() {
        CourseDAO dao = new CourseDAOImpl();
        Object[][] list = dao.getCourseArrayList();
        for (Object[] objects : list) {
            for (int j = 0; j < list[0].length; j++) {
                System.out.print(objects[j]);
            }
            System.out.println();
        }
    }

    @org.junit.Test
    public void testSchedule() {
        ScheduleDAO dao = new ScheduleDAOImpl();
        Object[][] list = dao.getScheduleArrayList();
        for (Object[] objects : list) {
            for (int j = 0; j < list[0].length; j++) {
                System.out.print(objects[j]);
            }
            System.out.println();
        }
    }

    //test for add
    @org.junit.Test
    public void addCourseTest() {
        CourseDAO dao = new CourseDAOImpl();
        boolean s = dao.addCourse(new Course(0, "courseName", 12.00, "benefit"));
        if(s) {
            System.out.println("success!");
        } else {
            System.out.println("fail!");
        }
    }

    @org.junit.Test
    public void addMemberTest() {
        MemberDAO dao = new MemberDAOImpl();
        boolean s = dao.addMember(new Member(0, "110", "123", "LiLi", "male", 1.80, 120.00, 5.00, 500.00, "membership"));
        if(s) {
            System.out.println("success!");
        } else {
            System.out.println("fail!");
        }
    }
}
