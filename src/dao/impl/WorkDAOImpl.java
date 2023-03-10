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
}
