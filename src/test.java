public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		course aerobic = new course("aerobic",1000,"enhace cardio-pulmonary function");
		course anaerobic = new course("anaerobic",1000,"promote explosive power");
		course strength = new course("strength",1000,"promote strength");
		
		membership wenxu = new membership( "wenxu","male", 250	,-10,-100);
		wenxu.showEverything();
		
		
		aerobic.showEverything();		
		System.out.print("a");
	}

}
