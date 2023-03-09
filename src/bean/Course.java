package bean;

public class Course {
    private Integer courseId;
    private String courseName;
    private Double price;
    private String benefit;

    public Course() {
    }

    public Course(Integer courseId, String courseName, Double price, String benefit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.price = price;
        this.benefit = benefit;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", price=" + price +
                ", benefit='" + benefit + '\'' +
                '}';
    }
}
