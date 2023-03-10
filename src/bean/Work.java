package bean;

public class Work {
    //fields of work
    private Integer workId;
    private String memberName;
    private String work;
    private String identity;

    //constructer
    public Work() {
    }
   //constructer
    public Work(Integer workId, String memberName, String work, String identity) {
        this.workId = workId;
        this.memberName = memberName;
        this.work = work;
        this.identity = identity;
    }

    //getter 
    public Integer getWorkId() {
        return workId;
    }

    //setter
    public void setWorkId(Integer workId) {
        this.workId = workId;
    }
    //getter 
    public String getMemberName() {
        return memberName;
    }
    //setter
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    //getter 
    public String getWork() {
        return work;
    }
    //setter
    public void setWork(String work) {
        this.work = work;
    }
    //getter 
    public String getIdentity() {
        return identity;
    }
    //setter
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
