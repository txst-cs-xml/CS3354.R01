public class Example {

	public static void main(String[] args) {
		SimpleSubject simpleSubject = new SimpleSubject();
		
		System.out.println("Register three observers");
		SimpleObserver simpleObserver1 = new SimpleObserver(simpleSubject);
		SimpleObserver simpleObserver2 = new SimpleObserver(simpleSubject);
		SimpleObserver simpleObserver3 = new SimpleObserver(simpleSubject);

		System.out.println("Update value");
		simpleSubject.setValue(80);
		
		System.out.println("Remove observer 1");
		simpleSubject.removeObserver(simpleObserver1);

		System.out.println("Update value");
		simpleSubject.setValue(100);

		System.out.println("Register observer 4");
		SimpleObserver simpleObserver4 = new SimpleObserver(simpleSubject);
		System.out.println("Update value");
		simpleSubject.setValue(150);

		System.out.println("Reregister observer 1");
		simpleSubject.registerObserver(simpleObserver1);
		System.out.println("Update value");
		simpleSubject.setValue(200);



	}

}
