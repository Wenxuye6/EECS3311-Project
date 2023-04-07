package dao;

import bean.Work;

import java.util.List;

public interface WorkDAO {

    //link with database
    Object[][] getWorkArrayListByName(String account);

    List<Work> getWorkListByName(String account);

    List<Work> getWorkList();

    void changeWorkName(String newName, String workName);

    void changeCoachName(String newName, String coachName);

    boolean addWork(Work work);

    void deleteWorkByName(String memberName, String work);
}
