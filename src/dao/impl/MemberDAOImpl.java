package dao.impl;

import bean.Member;
import dao.BaseDAO;
import dao.MemberDAO;

import java.util.List;

/**
 * User action implementation
   This class extends form BaseDao
 */
public class MemberDAOImpl extends BaseDAO<Member> implements MemberDAO {
    @Override
    public boolean login(Member member) {
        String sql = "select * from `t_member` where `account`=? and `password`=?";
        return getBean(sql, member.getAccount(), member.getPassword()) != null;
    }

    @Override
    public boolean addMember(Member member) {
        if (isExists(member.getAccount())) {
            return false;
        }
        String sql = "insert into `t_member`(`account`,`password`,`realName`,`gender`,`height`,`weight`,`BMI`,`Fund`,`identity`)values(?,?,?,?,?,?,?,?,?)";
        return update(sql, member.getAccount(), member.getPassword(), member.getRealName(), member.getGender(), member.getHeight(),
                member.getWeight(), member.getBMI(), member.getFund(), member.getIdentity()) > 0;
    }

    @Override
    public void change(Member newMember) {
        String sql = "update `t_member` set account=?,`password`=?,realName=?,gender=?,height=?,weight=?,BMI=?,Fund=?,identity=? where `memberId`=?";
        update(sql, newMember.getAccount(), newMember.getPassword(), newMember.getRealName(), newMember.getGender(), newMember.getHeight(),
                newMember.getWeight(), newMember.getBMI(), newMember.getFund(), newMember.getIdentity(), newMember.getMemberId());
    }

    @Override
    public boolean changeMember(Member newMember) {
        if (isExists(newMember.getAccount())) {
            return false;
        }
        String sql = "update `t_member` set account=?,`password`=?,realName=?,gender=?,height=?,weight=?,BMI=?,Fund=?,identity=? where `memberId`=?";
        return update(sql, newMember.getAccount(), newMember.getPassword(), newMember.getRealName(), newMember.getGender(), newMember.getHeight(),
                newMember.getWeight(), newMember.getBMI(), newMember.getFund(), newMember.getIdentity(), newMember.getMemberId()) > 0;
    }

    @Override
    public void deleteMemberById(int id) {
        String sql = "delete from `t_member` where `memberId`=?";
        update(sql, id);
    }

    @Override
    public String getIdentityByAccount(String account) {
        String sql = "select `identity` from `t_member` where `account`=?";
        return getBean(sql, account).getIdentity();
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
    public Object[][] getCoachArrayList() {
        String sql = "select * from `t_member` where `identity`='coach'";
        List<Object[]> l = getArrayList(sql);
        Object[][] list = new Object[l.size()][10];
        int i = 0;
        for (Object[] o : l) {
            list[i++] = o;
        }
        return list;
    }

    @Override
    public Member getMemberByAccount(String account) {
        String sql = "select * from `t_member` where `account`=?";
        return getBean(sql, account);
    }

    @Override
    public boolean isExists(String username) {
        String sql = "select * from `t_member` where `account`=?";
        return getBean(sql, username) != null;
    }
}
