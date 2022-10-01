package javaiIOtest.kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {
	public static void main(String[] args) {
		
		byte[] insrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outsrc = null;
		
		
		// 스트림 객체 생성 
		
		ByteArrayInputStream input = new ByteArrayInputStream(insrc); // 입력용 스트림 객체 
		ByteArrayOutputStream output = new ByteArrayOutputStream();  // 출력용 스트림 객체 
		
		int data;  // 읽어온 자료가 저장될 변수 
		
		//read() 메서드 ==> 더 이상 읽어올 자료가 없으면 -1을 반환한다.
		while((data = input.read())  != -1) {
			// 읽어온 자료를 사용하는 작업 코드를 작성한다.
			output.write(data); //출력
		}
		
		//출력된 스트림 값을 배열로 변환해서 저장
		
		 outsrc = output.toByteArray();
		 // 사용했던 스트림을 작업이 끝나면 반납한다. 
		 try {
			input.close();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 System.out.println("insrc = " + Arrays.toString(insrc));
		 System.out.println("outsrc = " +Arrays.toString(outsrc));
		
	}
}
