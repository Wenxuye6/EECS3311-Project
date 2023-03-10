
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bean.Admin;
import bean.Course;


public class junittests {
	@Test
	public void test1() {
		
		Admin admin = new Admin("SamiUllah", "12345");
		String username = admin.getUsername();
		assertEquals("SamiUllah", username);
		
		String password = admin.getPassword();
		assertEquals("12345", password);
		
	}
	
	
	
	
	@Test
	public void test2() {
		
		Admin admin = new Admin("amjad", "457901");
		String username = admin.getUsername();
		assertEquals("amjad", username);
		
		String password = admin.getPassword();
		assertEquals("457901", password);
		
	}
	
	
	
	
	@Test
	public void test3() {
		
		Admin admin = new Admin("amjad", "457901");
		
		admin.setUsername("rafi");
		admin.setPassword("234234");
		
		String username = admin.getUsername();
		assertEquals("rafi", username);
		
		String password = admin.getPassword();
		assertEquals("234234", password);
		
		
		
		
	}
	
	
	
	@Test
	public void test4() {
		Course course = new Course(12459, "gym1", 1000.0, "biceps tutorial");
		
		Integer id = course.getCourseId();
		assertEquals("12459", id);
		
		String coursename = course.getCourseName();
		assertEquals("gym1", coursename);
		
		Double price = course.getPrice();
		assertEquals("1000.0", price);
		
		String benefit = course.getBenefit();
		assertEquals("biceps tutorial", benefit);
	}
	
	
	
	@Test
	public void test5() {
		Course course = new Course(12459, "gym1", 1000.0, "biceps tutorial");
		
		course.setCourseId(55667);
		course.setCourseName("gym25");
		course.setPrice(1200.0);
		course.setBenefit("triceps workout");

        Integer id = course.getCourseId();
		assertEquals("55667", id);
		
		String coursename = course.getCourseName();
		assertEquals("gym25", coursename);
		
		Double price = course.getPrice();
		assertEquals("1200.0", price);
		
		String benefit = course.getBenefit();
		assertEquals("triceps workout", benefit);
		
		
	}
	
	
	
	
	

}