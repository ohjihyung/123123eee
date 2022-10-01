package javaiIOtest.kr.or.ddit.basic;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {
	public static void main(String[] args) {
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/test.dat");
			
			//자료형 단위로 출력할 보조스트림 dataOutputStream 객체 생성 
			DataOutputStream dout = new DataOutputStream(fout);
			

			
			
			dout.writeInt(200); // 정수형으로 출력 
			dout.writeFloat(123.456f); // 실수형으로 출력 
			dout.writeBoolean(false); // 논리형으로 출력 
			dout.writeUTF("ABCDabcd"); //문자열형식으로 출력 
			
			//깨져서 나오는 이유 
				/*
				     1. 처음에 정수형으로 출력 0000000000000111010  
				     2.	실수도 위와 마찬가지
				     3. false = 1byte 
				     4. 문자열 앞에는 BS = 문자열 길이 (8)
				 */
			
			
			System.out.println("출력완료");
			
			dout.close();
			
			// 출력한 자료 읽어오기 
			
			
			FileInputStream fis = new FileInputStream("d:/d_other/test.dat");
			DataInputStream dis = new DataInputStream(fis);
			
			
			//DataInputStream으로 자료를 읽어올 때는 출력했을 때의 순서와 같은 순서로 읽어와야 한다.
			
			System.out.println("정수형 : " + dis.readInt());
			System.out.println("실수형 : " + dis.readFloat());
			System.out.println("논수형 : " + dis.readBoolean());
			System.out.println("문자열형 : " + dis.readUTF());
			
			
			fis.close();
			dis.close();
			
			
			
			
		}catch(IOException e) {}
		
		
		
	}
}
