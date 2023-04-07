import bean.Course;
import bean.Member;
import bean.Schedule;
import bean.Work;
import dao.CourseDAO;
import dao.MemberDAO;
import dao.ScheduleDAO;
import dao.WorkDAO;
import dao.impl.CourseDAOImpl;
import dao.impl.MemberDAOImpl;
import dao.impl.ScheduleDAOImpl;
import dao.impl.WorkDAOImpl;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

public class TestSelectCourse {

    private void printList(List<Object> list) {
        for(Object o : list) {
            System.out.println(o);
        }
    }

    @Test
    public void testSelectCourse() {
        CourseDAO courseDAO = new CourseDAOImpl();
        MemberDAO memberDAO = new MemberDAOImpl();
        ScheduleDAO scheduleDAO = new ScheduleDAOImpl();
        WorkDAO workDAO = new WorkDAOImpl();
        Course newCourse = new Course(null, "NewCourse", 120.00, "benefit");
        Member newM = new Member(0, "NewMembership", "123", "NewMembership", "male", 0.0, 0.0, 0.0, 0.0, "membership");
        Member newC = new Member(0, "NewCoach", "123", "NewCoach", "male", 0.0, 0.0, 0.0, 0.0, "coach");
        courseDAO.addCourse(newCourse);
        memberDAO.addMember(newM);
        memberDAO.addMember(newC);

        if(scheduleDAO.courseExist(newM.getAccount(), newCourse.getCourseName())) {
            System.out.println("Course Repetition!");
        } else {
            scheduleDAO.addSchedule(new Schedule(null, newM.getAccount(), newCourse.getCourseName(), newC.getAccount()));
            workDAO.addWork(new Work(null, newC.getAccount(), newCourse.getCourseName(), "coach"));
            System.out.println("success!");
        }

        //CourseList
        printList(Collections.singletonList(courseDAO.getCourseList()));
        //ScheduleList
        printList(Collections.singletonList(scheduleDAO.getOwnScheduleList(newM.getAccount())));
        //WorkList
        printList(Collections.singletonList(workDAO.getWorkListByName(newC.getAccount())));
    }
}
