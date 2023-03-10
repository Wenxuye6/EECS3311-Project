package bean;

public class Schedule {
    private Integer scheduleId;
    private String memberName;
    private String courseName;
    private String coachName;

    public Schedule() {
    }

    public Schedule(Integer scheduleId, String memberName, String courseName, String coachName) {
        this.scheduleId = scheduleId;
        this.memberName = memberName;
        this.courseName = courseName;
        this.coachName = coachName;
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

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
