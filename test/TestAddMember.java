import bean.Member;
import dao.MemberDAO;
import dao.impl.MemberDAOImpl;
import org.junit.Test;

import java.util.List;

public class TestAddMember {

    private void printList(List<Member> list) {
        for(Member m : list) {
            System.out.println(m);
        }
    }

    @Test
    public void testAddMemberShip() {
        MemberDAO dao = new MemberDAOImpl();
        //printList(dao.getMemberList());

        //Add Member
        Member newMember = new Member(0, "NewMembership", "123", "NewMembership", "male", 0.0, 0.0, 0.0, 0.0, "membership");
        boolean success = dao.addMember(newMember);
        if(success) {
            System.out.println("Successfully added");
        } else {
            System.out.println("Add failed");
        }

        //printList(dao.getMemberList());
    }

    @Test
    public void testAddCoach() {
        MemberDAO dao = new MemberDAOImpl();
        //printList(dao.getMemberList());

        //Add Member
        Member newMember = new Member(0, "NewCoach", "123", "NewCoach", "male", 0.0, 0.0, 0.0, 0.0, "coach");
        boolean success = dao.addMember(newMember);
        if(success) {
            System.out.println("Successfully added");
        } else {
            System.out.println("Add failed");
        }

        //printList(dao.getMemberList());
    }

    @Test
    public void testAddJanitorial() {
        MemberDAO dao = new MemberDAOImpl();
        //printList(dao.getMemberList());

        //Add Member
        Member newMember = new Member(0, "NewJanitorial", "123", "NewJanitorial", "male", 0.0, 0.0, 0.0, 0.0, "janitorial");
        boolean success = dao.addMember(newMember);
        if(success) {
            System.out.println("Successfully added");
        } else {
            System.out.println("Add failed");
        }

        //printList(dao.getMemberList());
    }

    @Test
    public void testAddFrontDesk() {
        MemberDAO dao = new MemberDAOImpl();
        //printList(dao.getMemberList());

        //Add Member
        Member newMember = new Member(0, "NewFrontDesk", "123", "NewFrontDesk", "male", 0.0, 0.0, 0.0, 0.0, "front desk");
        boolean success = dao.addMember(newMember);
        if(success) {
            System.out.println("Successfully added");
        } else {
            System.out.println("Add failed");
        }

        //printList(dao.getMemberList());
    }
}
