package ch18.network.udp.main2;

public abstract class AbstractClientSocket {
	protected String name;
	protected IClientUser clientUser;
	
	/** 해당 생성자 함수를 강제적으로 처리하기 위해 추갓ㅇ클래스 사용 */
	public AbstractClientSocket(String name, IClientUser clientUser) {
		this.name = name;
		this.clientUser = clientUser;
	}
	
	/** 추상 메소드 정의 */
	public abstract void sendMessage(String msg);
	public abstract void connect();
	public abstract void close();
}
