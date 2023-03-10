package dao.impl;

import bean.Admin;
import dao.AdminDAO;
import dao.BaseDAO;

/**
 * Administrator operation implementation
 */
public class AdminDAOImpl extends BaseDAO<Admin> implements AdminDAO {
    @Override
    public boolean login(Admin admin) {
        String sql = "select * from `t_admin` where `username`=? and `password`=?";
        return getBean(sql, admin.getUsername(), admin.getPassword()) != null;
    }

    @Override
    public void updateAdmin(Admin newAdmin) {
        String sql = "update `t_admin` set `password`=? where `username`='root'";
        update(sql, newAdmin.getPassword());
    }
}
