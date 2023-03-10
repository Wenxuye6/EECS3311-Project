package bean;

/**
 * User entity classes
 */
public class Member {
    private Integer memberId;
    private String account; //User account
    private String password; //User password
    private String realName;
    private String gender;
    private Double height;
    private Double weight;
    private Double BMI;
    private Double Fund;
    private String identity;

    public Member() {
    }

    public Member(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Member(Integer memberId, String account, String password, String realName, String gender, Double height, Double weight, Double BMI, Double fund, String identity) {
        this.memberId = memberId;
        this.account = account;
        this.password = password;
        this.realName = realName;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.BMI = BMI;
        Fund = fund;
        this.identity = identity;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBMI() {
        return BMI;
    }

    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    public Double getFund() {
        return Fund;
    }

    public void setFund(Double fund) {
        Fund = fund;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", BMI=" + BMI +
                ", Fund=" + Fund +
                ", identity='" + identity + '\'' +
                '}';
    }
}
