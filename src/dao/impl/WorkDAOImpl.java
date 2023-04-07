package dao.impl;

import bean.Work;
import dao.BaseDAO;
import dao.WorkDAO;

import java.util.List;

/**
 * Welcome to WorkDAOImpl class, this class extends BaseDao
 */
public class WorkDAOImpl extends BaseDAO<Work> implements WorkDAO {
    @Override
    public Object[][] getWorkArrayListByName(String account) {
        String sql = "select * from `t_work` where `memberName`=?";
        List<Object[]> l = getArrayList(sql, account);
        Object[][] list = new Object[l.size()][4];
        int i = 0;
        for (Object[] o : l) {
            list[i++] = o;
        }
        return list;
    }

    @Override
    public List<Work> getWorkListByName(String account) {
        String sql = "select * from `t_work` where `memberName`=?";
        return getBeanList(sql, account);
    }

    @Override
    public List<Work> getWorkList() {
        String sql = "select * from `t_work`";
        return getBeanList(sql);
    }

    @Override
    public void changeWorkName(String newName, String workName) {
        String sql = "update `t_work` set `work`=? where `work`=?";
        update(sql, newName, workName);
    }

    @Override
    public void changeCoachName(String newName, String coachName) {
        String sql = "update `t_work` set `memberName`=? where `memberName`=?";
        update(sql, newName, coachName);
    }

    @Override
    public boolean addWork(Work work) {
        String sql = "insert into `t_work`(`memberName`,`work`,`identity`)values(?,?,?)";
        return update(sql, work.getMemberName(), work.getWork(), work.getIdentity()) > 0;
    }

    @Override
    public void deleteWorkByName(String memberName, String work) {
        String sql = "delete from `t_work` where `memberName`=? and `work`=?";
        update(sql, memberName, work);
    }
}
