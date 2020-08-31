package aula20200817.threads;

public class AppThreads {
	
	public static void main(String[] args) {
		Runnable r1 = () -> {
			long total = 0;
			for (int i = 0; i < 100; i++) {
				total++;
			}
			System.out.println(">>> " + total);
		};

		for (int i = 0; i < 20; i++) {
			new Thread(r1).start();
		}
		System.out.println("Fim.");
	}

	/*
	Runnable r1 = new Runnable() {
		@Override
		public void run() {
			long total = 0;
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				total++;
			}
			System.out.println(">>> " + total);
		}
	};
	*/
	
	/*
	Thread t1 = new Thread() {
		@Override
		public void run() {
			long total = 0;
			for (int i = 0; i < 100; i++) {
				try {
					sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				total++;
			}
			System.out.println(">>> " + total);
		}
	};
	*/

}
