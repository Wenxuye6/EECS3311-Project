package dao.impl;

import bean.Member;
import dao.BaseDAO;
import dao.MemberDAO;

import java.util.List;

/**
 * User action implementation
 */
public class MemberDAOImpl extends BaseDAO<Member> implements MemberDAO {
    @Override
    public boolean login(Member member) {
        String sql = "select * from `t_member` where `account`=? and `password`=?";
        return getBean(sql, member.getAccount(), member.getPassword()) != null;
    }

    @Override
    public boolean register(Member Member) {
        if (isExists(Member.getAccount())) {
            return false;
        }
        String sql = "insert into `t_member`(`account`,`password`)values(?,?)";
        return update(sql, Member.getAccount(), Member.getPassword()) > 0;
    }

    @Override
    public boolean addMember(Member Member) {
        if (isExists(Member.getAccount())) {
            return false;
        }
        String sql = "insert into `t_member`(`account`,`password`,`realName`,`gender`,`height`,`weight`,`BMI`,`Fund`,`VIP`)values(?,?,?,?,?,?,?,?,?)";
        return update(sql, Member.getAccount(), Member.getPassword(), Member.getRealName(), Member.getGender(), Member.getHeight(),
                Member.getWeight(), Member.getBMI(), Member.getFund(), Member.getVIP()) > 0;
    }

    @Override
    public void change(Member newMember) {
        String sql = "update `t_member` set `password`=? where `account`=?";
        update(sql, newMember.getPassword(), newMember.getAccount());
    }

    @Override
    public void changeMember(Member newMember) {
        String sql = "update `t_member` set account=?,`password`=?,realName=?,gender=?,height=?,weight=?,BMI=?,Fund=?,VIP=? where `id`=?";
        update(sql, newMember.getAccount(), newMember.getPassword(), newMember.getRealName(), newMember.getGender(), newMember.getHeight(), newMember.getWeight(), newMember.getBMI(), newMember.getFund(), newMember.getVIP(), newMember.getId());
    }

    @Override
    public void cancel(Member member) {
        String sql = "delete from `t_member` where `account`=? and `password`=?";
        update(sql, member.getAccount(), member.getPassword());
    }

    @Override
    public Object[][] getUserArrayList() {
        String sql = "select * from `t_member`";
        List<Object[]> l = getArrayList(sql);
        Object[][] list = new Object[l.size()][10];
        int i = 0;
        for (Object[] o : l) {
            list[i++] = o;
        }
        return list;
    }

    @Override
    public Member getMemberById(int id) {
        String sql = "select * from `t_member` where `id`=?";
        return getBean(sql, id);
    }

    @Override
    public boolean isExists(String username) {
        String sql = "select * from `t_member` where `account`=?";
        return getBean(sql, username) != null;
    }
}
