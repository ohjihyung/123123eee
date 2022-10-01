package javaiIOtest.kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferIOTest2 {
	
	public static void main(String[] args) {
		
		try {
			//이클립스에서 자바 프로그램이 실행되는 현재 위치는 해당 프로젝트 폴더가 현재 위치가 된다.
			FileReader fr = new FileReader("d:/d_other/buffered.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String temp = "";
			
			// 입력용 문자 기반의 버퍼스트림은 한줄 단위로 읽어오는 기능이 있다.
			// readLine() 메서드 ==> 한줄 씩 읽어온다 (읽어온 내용이 없으면 null 반환)
			
			for(int i = 1; (temp = br.readLine()) != null ; i++) {
				System.out.printf("%4d : %s\n", i, temp);
			}
			br.close();
			
		}catch(IOException e) {}
		
		
	}
	
	
}
