package ch18.network.http.main2.sub3;

import java.net.URI;
import java.net.URL;

public class TestMain {

	public static void main(String[] args) throws Exception{
		
		String path = "http://www.website.com:8080";
		path += "/depth1/page.jsp?param1=��1#123&param2=��2"; /* Error */
		//path += "/depth1/page.jsp?param1=123&param2=��2";
		
		/** URL ��ü���� �� �Լ� ��� */
		URL url = new URL(path);
		System.out.println("------------------------------------");
		System.out.println("URL �Լ�");
		System.out.println("------------------------------------");
		print("��ü���", path);
		print("getProtocol", url.getProtocol());
		print("getHost", url.getHost());
		print("getPort", url.getPort());
		print("getPath", url.getPath());
		print("getFile", url.getFile());
		print("getQuery", url.getQuery());
		print("getAuthority", url.getAuthority());
		print("getRef", url.getRef());
		print("getDefaultPort", url.getDefaultPort());
		print("toExternalForm", url.toExternalForm());
		System.out.println();
		System.out.println("------------------------------------");
		
		/** URI ��ü ���� �� �Լ� ��� */
		URI uri = url.toURI();
		System.out.println("------------------------------------");
		System.out.println("URI �Լ�");
		System.out.println("------------------------------------");
		print("getScheme", uri.getScheme());
		print("getHost", uri.getHost());
		print("getPort", uri.getPort());
		print("getPath", uri.getPath());
		print("getRawPath", uri.getRawPath());
		print("getQuery", uri.getQuery());
		print("getRawQuery", uri.getRawQuery());
		print("getAuthority", uri.getAuthority());
		print("getRawAuthority", uri.getRawAuthority());
		print("getFragment", uri.getFragment());
		print("getRawFragment", uri.getRawFragment());
		print("getSchemeSpecificPart", uri.getSchemeSpecificPart());
		print("toASCIIString", uri.toASCIIString());
		print("toString", uri.toString());
		System.out.println("------------------------------------");
		
		URI uri2 = new URI("http://www.website.com/path1/..././path2/file.jsp");
		URI uri3 = uri2.normalize();
		print("uri2 ������ uri", uri2.toString());
		print("uri2������ uri", uri3.toString());
		System.out.println("------------------------------------");
		
		URI uri4 = new URI("/path1/path2/file.jsp");
		print("uri4 uri", uri4.toString());
		print("uri4 isAbsolute", uri4.isAbsolute());
		System.out.println("------------------------------------");
		
		URI uri5 = new URI("http://example.com/something/more/long");
		URI uri6 = new URI("/path1/path2/file.jsp");
		URI uri7 = uri5.resolve(uri6);
		print("uri5 ���", uri5.toString());
		print("uri6 �����", uri6.toString());
		print("uri7 resolve uri", uri7.toString());
		System.out.println("------------------------------------");

	}
	
	/* �ܼ�ȭ�� ����� ���� print() �Լ� ���� */
	public static void print(String name, Object value) {
		System.out.println("["+name+"] = \t"+value);
	}

}
