package budgetPackage;

public class BudgetTester {
	private static int debugmode = 0;
	public static void main(String[] args) {
		//TODO add code to read debug mode from command line
		Thread thread = new Thread(){
		    public void run(){
		      BudgetPercept tester = new BudgetPercept();
		      tester.setDebugMode(debugmode);
		    }
		  };
		thread.start();
	}
}
