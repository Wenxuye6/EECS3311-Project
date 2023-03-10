package bean;

public class Schedule {
    //schedule fields
    private Integer scheduleId;
    private String memberName;
    private String courseName;
    private String coachName;

    //constructers
    public Schedule() {
    }

    
    //constructers
    public Schedule(Integer scheduleId, String memberName, String courseName, String coachName) {
        this.scheduleId = scheduleId;
        this.memberName = memberName;
        this.courseName = courseName;
        this.coachName = coachName;
    }

    //getters of ID
    public Integer getScheduleId() {
        return scheduleId;
    }
 
    //setters of ID
    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    //getters of name
    public String getMemberName() {
        return memberName;
    }

    //setters of name
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    //getters of name
    public String getCourseName() {
        return courseName;
    }

    //setters of name
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    //getters coachname
    public String getCoachName() {
        return coachName;
    }

    //setters coach name
    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    //print methods
    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", memberName='" + memberName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", coachName='" + coachName + '\'' +
                '}';
    }
}
