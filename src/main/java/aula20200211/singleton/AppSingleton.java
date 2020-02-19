package aula20200211.singleton;

public class AppSingleton {
	
	public static void main(String[] args) {
		Universo u1 = Universo.getInstance();
		Universo u2 = Universo.getInstance();
		Universo u3 = Universo.getInstance();
		Universo u4 = Universo.getInstance();
		Universo u5 = Universo.getInstance();
		
		
		System.out.println(u1);
		System.out.println(u2);
		System.out.println(u3);
		System.out.println(u4);
		System.out.println(u5);
	}
}
