package dao;

import bean.Admin;

/**
 * Administrator operating interface
 */
public interface AdminDAO {

    boolean login(Admin admin);

    void updateAdmin(Admin newAdmin);
}
