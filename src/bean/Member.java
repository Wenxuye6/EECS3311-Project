package bean;

/**
 * User entity classes
 */
public class Member {
    private int id;
    private String account; //User account
    private String password; //User Password
    private String realName;
    private String gender;
    private double height;
    private double weight;
    private double BMI;
    private double Fund;
    private String VIP;

    public Member() {
    }

    public Member(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public Member(int id, String account, String password, String realName, String gender, double height, double weight, double BMI, double Fund, String VIP) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.realName = realName;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.BMI = BMI;
        this.Fund = Fund;
        this.VIP = VIP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public double getFund() {
        return Fund;
    }

    public void setFund(double fund) {
        this.Fund = fund;
    }

    public String getVIP() {
        return VIP;
    }

    public void setVIP(String VIP) {
        this.VIP = VIP;
    }
}
