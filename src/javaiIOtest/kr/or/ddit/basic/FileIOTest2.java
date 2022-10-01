package javaiIOtest.kr.or.ddit.basic;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest2 {
	public static void main(String[] args) throws IOException {
		
		//byte 기반의 File 출력용 스트림을 이용하여 데이터 출력하기 
		
		//출력용 스트림 생성 
		FileOutputStream fis = new FileOutputStream("d:/d_other/test2.txt");
		
		for(char ch ='A'; ch <= 'Z'; ch++) {	
			fis.write(ch);
			
		}
		
		System.out.println("쓰기 작업 완료");
		fis.close();		
	
	}
}
