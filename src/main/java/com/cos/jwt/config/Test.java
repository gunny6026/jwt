package com.cos.jwt.config;

	interface Mycallback {
		void callback(int money);
	}

 class MoneyChange {
	int money = 10000;
	
	public void send(Mycallback myCallback) {
		
		// 새로운 스레드 실행
		new Thread(new Runnable() {
			
			@Override
			public void run() {
					try {
						Thread.sleep(3000);
						money += 20000;
						myCallback.callback(money);
					}catch(Exception e){
						System.out.println(e.getMessage());
						
					}
			}
		}).start();
		
		
	}
}

public class Test {
	
	public static void main(String[] args) {
		System.out.println("그림 1");
		System.out.println("그림 2");
		MoneyChange m = new MoneyChange();
		 m.send(new Mycallback() {
			
			@Override
			public void callback(int money) {
				// TODO Auto-generated method stub
				System.out.println(money);
				System.out.println("그림4:"+money);
			}
		});
		 System.out.println("그림3");
		
	}

}
