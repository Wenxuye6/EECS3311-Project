
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bean.Admin;
import bean.Course;
import bean.Member;
import bean.Schedule;


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
	
	
	
	
	@Test
	public void test6() {
		Member member = new Member(1234, "acct1", "12sami", "samiullah", "male", 5.11, 80.0, 30.0, 150.0, "Canadian");
		
		member.setMemberId(1456);
		member.setAccount("acct2");
		member.setPassword("12ullah");
		member.setRealName("ullahji");
		member.setGender("female");
		member.setHeight(5.9);
		member.setWeight(90.0);
		member.setBMI(35.0);
		member.setFund(200.0);
		member.setIdentity("american");
		
		Integer id = member.getMemberId();
		assertEquals("1456", id);
		
		String account = member.getAccount();
		assertEquals("acct2", account);
		
		String password = member.getPassword();
		assertEquals("12ullah", password);
		
		String name = member.getRealName();
		assertEquals("ullahji", name);
		
		String gender = member.getGender();
		assertEquals("female", gender);
		
		Double height = member.getHeight();
		assertEquals("5.9", height);
		
		Double weight = member.getWeight();
		assertEquals("90.0", weight);
		
		Double bmi = member.getBMI();
		assertEquals("35.0", bmi);
		
		Double fund = member.getFund();
		assertEquals("200.0", fund);
				
		String ident = member.getIdentity();
		assertEquals("american", ident);
	}
	
	
	
	
	
	@Test
	public void test7() {
		Schedule sched = new Schedule(1234, "sami", "gym20", "jim");
		
		sched.setCoachName("jeff");
		sched.setMemberName("irfan");
		sched.setCourseName("gym60");
		sched.setScheduleId(5546);
		
		Integer id = sched.getScheduleId();
		assertEquals("5546", id);
		
		String coach = sched.getCoachName();
		assertEquals("jeff", coach);
		
		String name = sched.getMemberName();
		assertEquals("irfan", name);
		
		String course = sched.getCourseName();
		assertEquals("gym60", course);
		
		assertEquals("Schedule{" +
                "scheduleId=" + "5546" + ", memberName='" + "irfan" + '\'' + ", courseName='" + "gym60" + '\'' + ", coachName='" + '\'' + '}', sched.toString());
		
		
	}
	
	
	
	@Test
	public void test8() {
		Work work= new Work(1234, "Sami", "Cleaning", "American");
		
		work.setWorkId(4506);
		work.setMemberName("Umer");
		work.setWork("Inventory Work");
		work.setIdentity("Canadian");
		
		Integer ID = work.getWorkId();
		assertEquals("4506", ID);
		
		String Name = work.getMemberName();
		assertEquals("Umer", Name);
		
		String kam = work.getWork();
		assertEquals("Inventory Work", kam);
		
		String identity = work.getIdentity();
		assertEquals("Canadian", identity);
		
		assertEquals("Work{" +
                "workId=" + "4506" +
                ", memberName='" + "Umer" + '\'' +
                ", work='" + "Inventory Work" + '\'' +
                ", identity='" + "Canadian" + '\'' +
                '}', work.toString());
		
		
	}
	
	@Test
	public void test9() {
		Equipment Equip = new Equipment(340, "bench", 56, 10, 100.0, "hundred");
		
		Equip.setEquipmentId(560);
		Equip.setEquipmentName("dumbel");
		Equip.setCurrentNum(100);
		Equip.setDamagedNum(5);
		Equip.setMarketPrice(140.0);
		Equip.setValue("one forty");
		
		Integer id = Equip.getEquipmentId();
		assertEquals("560", id);
		
		String name = Equip.getEquipmentName();
		assertEquals("dumbel", name);
		
		Integer currentnum = Equip.getCurrentNum();
		assertEquals("100", currentnum);
		
		Integer damnum = Equip.getDamagedNum();
		assertEquals("5", damnum);
		
		Double price = Equip.getMarketPrice();
		assertEquals("140.0", price);
		
		String value = Equip.getValue();
		assertEquals("one forty", value);
		
		
		assertEquals("Equipment{" +
                "equipmentId=" + "560" +
                ", equipmentName='" + "dumbel" + '\'' +
                ", currentNum=" + "100" +
                ", damagedNum=" + "5" +
                ", marketPrice=" + "140.0" +
                ", value='" + "one forty" + '\'' +
                '}', Equip.toString());
		
		
	}
	

}
