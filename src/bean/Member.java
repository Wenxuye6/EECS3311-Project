package bean;

/**
 * User entity classes
 */
public class Member {
    //fields of a member
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

    //No-Arg Constructor.
    public Member() {
    }

    //Parameterized Constructor.
    public Member(String account, String password) {
        this.account = account;
        this.password = password;
    }

    //Parameterized Constructor.
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

    //getter id
    public Integer getMemberId() {
        return memberId;
    }

    //setter id
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    //getter account
    public String getAccount() {
        return account;
    }

    //setter account
    public void setAccount(String account) {
        this.account = account;
    }

    //getter password
    public String getPassword() {
        return password;
    }

    //setter password
    public void setPassword(String password) {
        this.password = password;
    }

    //getter real name
    public String getRealName() {
        return realName;
    }

    //setter real name
    public void setRealName(String realName) {
        this.realName = realName;
    }

    //getter gender
    public String getGender() {
        return gender;
    }

    //setter gender
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    //getter height
    public Double getHeight() {
        return height;
    }

    //setter height
    public void setHeight(Double height) {
        this.height = height;
    }

    
    //getter weight
    public Double getWeight() {
        return weight;
    }

    //setter weight
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    //getter bmi
    public Double getBMI() {
        return BMI;
    }

    //setter bmi
    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    //getter fund
    public Double getFund() {
        return Fund;
    }

    //setter fund
    public void setFund(Double fund) {
        Fund = fund;
    }

    public String getIdentity() {
        return identity;
    }

    //getter identity
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    //print method
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
