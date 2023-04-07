package bean;

public class Course {
    //fields of a course
    private Integer courseId;
    private String courseName;
    private Double price;
    private String benefit;

    //No-Arg Constructor.
    public Course() {
    }

    //Parameterized Constructor.
    public Course(Integer courseId, String courseName, Double price, String benefit) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.price = price;
        this.benefit = benefit;
    }

    //getter for ID
    public Integer getCourseId() {
        return courseId;
    }

    //setter ID
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    //getter name
    public String getCourseName() {
        return courseName;
    }

    //setter name
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    //getter price
    public Double getPrice() {
        return price;
    }

    //setter price
    public void setPrice(Double price) {
        this.price = price;
    }

    //getter benefit
    public String getBenefit() {
        return benefit;
    }

    //setter benefit
    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    //print method
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
