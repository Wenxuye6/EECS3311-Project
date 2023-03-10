package dao.impl;

import bean.Schedule;
import dao.BaseDAO;
import dao.ScheduleDAO;

import java.util.List;

public class ScheduleDAOImpl extends BaseDAO<Schedule> implements ScheduleDAO {
    @Override
    public Object[][] getScheduleArrayList() {
        String sql = "select * from t_schedule";
        List<Object[]> l = getArrayList(sql);
        Object[][] list = new Object[l.size()][4];
        int i = 0;
        for (Object[] o : l) {
            list[i++] = o;
        }
        return list;
    }

    @Override
    public boolean addSchedule(Schedule schedule) {
        String sql = "insert into `t_schedule`(`memberName`,`courseName`,`coachName`)values(?,?,?)";
        return update(sql, schedule.getMemberName(), schedule.getCourseName(), schedule.getCoachName()) > 0;
    }

    @Override
    public void deleteScheduleById(int id) {
        String sql = "delete from `t_schedule` where `scheduleId`=?";
        update(sql, id);
    }

    @Override
    public void changeSchedule(Schedule newSchedule) {
        String sql = "update `t_schedule` set `memberName`=?,`courseName`=?,`coachName`=? where `scheduleId`=?";
        update(sql, newSchedule.getMemberName(), newSchedule.getCourseName(), newSchedule.getCoachName(), newSchedule.getScheduleId());
    }

    @Override
    public void changeCourseName(String newName, String courseName) {
        String sql = "update `t_schedule` set `courseName`=? where `courseName`=?";
        update(sql, newName, courseName);
    }

    @Override
    public boolean coachExist(String coachName) {
        String sql = "select * from `t_schedule` where `coachName`=?";
        return getBeanList(sql, coachName).size() > 0;
    }

    @Override
    public boolean courseExist(String courseName) {
        String sql = "select * from `t_schedule` where `courseName`=?";
        return getBeanList(sql, courseName).size() > 0;
    }

    @Override
    public boolean memberExist(String memberName) {
        String sql = "select * from `t_schedule` where `memberName`=?";
        return getBeanList(sql, memberName).size() > 0;
    }
}
