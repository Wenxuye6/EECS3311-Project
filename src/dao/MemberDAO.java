package dao;

import bean.Member;

import java.util.List;

/**
 * User operating interface
 */
public interface MemberDAO {

    //display attributes
    boolean login(Member member);

    boolean addMember(Member member);

    void change(Member newMember);

    boolean changeMember(Member newMember);

    void deleteMemberById(int id);

    String getIdentityByAccount(String account);

    void cancel(Member member);

    Object[][] getUserArrayList();

    List<Member> getMemberList();

    Object[][] getCoachArrayList();

    Member getMemberByAccount(String account);

    void updateFund(String account, String Fund);

    Double getFundByAccount(String account);

    boolean isExists(String username);
}
