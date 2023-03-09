package dao;

import bean.Schedule;

public interface ScheduleDAO {

    Object[][] getScheduleArrayList();

    boolean addSchedule(Schedule schedule);

    void deleteScheduleById(int id);

    void changeSchedule(Schedule newSchedule);

    boolean coachExist(String coachName);

    boolean courseExist(String courseName);

    boolean memberExist(String memberName);
}
