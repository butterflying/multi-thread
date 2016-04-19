package base;
/**
 * 
 * @author zlb
 */
public class DeadLock {
	private static Object lockA = new Object();
	private static Object lockB = new Object();
	
	public static void main(String[] args) {
		//创建两个线程
		new Thread(() -> {
			synchronized (lockA) {
				try {
					Thread.currentThread().sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (lockB) {
					System.out.println("我先拿到了lockA,又拿到了lockB，你敢信？");
				}
			}
		}).start();
		
		new Thread(() -> {
			synchronized (lockB) {
				try {
					Thread.currentThread().sleep(2000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				synchronized (lockA) {
					System.out.println("我拿到了lockB,又拿到了lockA，你敢信？");
				}
			}
		}).start();
		//
	}
}
