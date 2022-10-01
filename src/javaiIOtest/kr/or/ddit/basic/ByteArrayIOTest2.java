package javaiIOtest.kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest2 {
	public static void main(String[] args) {
		
		byte[] insrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outsrc = null;
		
		byte[] temp = new byte[4]; // 4개짜리 배열 생성
		
		// 스트림 객체 생성 
		
		ByteArrayInputStream input = new ByteArrayInputStream(insrc); // 입력용 스트림 객체 
		ByteArrayOutputStream output = new ByteArrayOutputStream();  // 출력용 스트림 객체 
		
		try {
			//읽어올 데이터가 있는지 확인 
			//input.available() ==> 읽어올 수 있는 데이터의 개수를 반환
			while(input.available() > 0) {	
				int len = input.read(temp); //실제 읽어온 byte 수를 반환 
//				output.write(temp); // 쓰기
				
				output.write(temp, 0, len);
				
				System.out.println("반복문 안에서 temp = " + Arrays.toString(temp));
			}
			
			System.out.println();
			outsrc = output.toByteArray();
			System.out.println("insrc = " + Arrays.toString(insrc));
			System.out.println("outsrc = " + Arrays.toString(outsrc));

			//스트림 닫기
			input.close();
			output.close();
		}catch(IOException e) {
			
		}
		
		
		
	}
}
