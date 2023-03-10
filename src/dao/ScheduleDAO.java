package dao;

import bean.Schedule;

public interface ScheduleDAO {

    //link with databse
    Object[][] getScheduleArrayList();

    //display attributes
    boolean addSchedule(Schedule schedule);

    void deleteScheduleById(int id);

    void changeSchedule(Schedule newSchedule);

    void changeCourseName(String newName, String courseName);

    boolean coachExist(String coachName);

    boolean courseExist(String courseName);

    boolean memberExist(String memberName);
}
