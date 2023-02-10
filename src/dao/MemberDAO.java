package dao;

import bean.Member;

/**
 * User operating interface
 */
public interface MemberDAO {

    boolean login(Member member);

    boolean register(Member Member);

    boolean addMember(Member Member);

    void change(Member newMember);

    void changeMember(Member newMember);

    void cancel(Member member);

    Object[][] getUserArrayList();

    Member getMemberById(int id);

    boolean isExists(String username);
}
