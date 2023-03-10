package bean;

public class Work {
    private Integer workId;
    private String memberName;
    private String work;
    private String identity;

    public Work() {
    }

    public Work(Integer workId, String memberName, String work, String identity) {
        this.workId = workId;
        this.memberName = memberName;
        this.work = work;
        this.identity = identity;
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Work{" +
                "workId=" + workId +
                ", memberName='" + memberName + '\'' +
                ", work='" + work + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
