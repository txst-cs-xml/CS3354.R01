public class SingletonClient {
	public static void main(String[] args) {
		Singleton singleton = Singleton.getInstance();
		System.out.println(singleton.getDescription());
		Singleton a = Singleton.getInstance();
		System.out.println(a.getDescription());
	}
}
