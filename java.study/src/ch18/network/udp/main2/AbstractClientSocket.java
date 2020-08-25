package ch18.network.udp.main2;

public abstract class AbstractClientSocket {
	protected String name;
	protected IClientUser clientUser;
	
	/** �ش� ������ �Լ��� ���������� ó���ϱ� ���� �߰���Ŭ���� ��� */
	public AbstractClientSocket(String name, IClientUser clientUser) {
		this.name = name;
		this.clientUser = clientUser;
	}
	
	/** �߻� �޼ҵ� ���� */
	public abstract void sendMessage(String msg);
	public abstract void connect();
	public abstract void close();
}
