package dao;

import bean.Schedule;

import java.util.List;

public interface ScheduleDAO {

    //link with databse
    Object[][] getOwnScheduleArrayList(String memberName);

    Object[][] getScheduleArrayList();

    List<Schedule> getScheduleList();

    //display attributes
    boolean addSchedule(Schedule schedule);

    void deleteScheduleById(int id);

    void changeSchedule(Schedule newSchedule);

    void changeCourseName(String newName, String courseName);

    boolean coachExist(String coachName);

    boolean courseExist(String courseName);

    boolean memberExist(String memberName);

    boolean courseExist(String memberName, String courseName);
}
