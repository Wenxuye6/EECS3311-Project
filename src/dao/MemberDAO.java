package dao;

import bean.Member;

/**
 * User operating interface
 */
public interface MemberDAO {

    boolean login(Member member);

    boolean addMember(Member member);

    void change(Member newMember);

    boolean changeMember(Member newMember);

    void deleteMemberById(int id);

    String getIdentityByAccount(String account);

    void cancel(Member member);

    Object[][] getUserArrayList();

    Object[][] getCoachArrayList();

    Member getMemberByAccount(String account);

    boolean isExists(String username);
}
