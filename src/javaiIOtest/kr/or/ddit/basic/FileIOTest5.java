package javaiIOtest.kr.or.ddit.basic;


import java.io.FileInputStream;
import java.io.FileReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest5 {
	
	
	public static void main(String[] args) throws IOException {
	
		//한글이 저장된 파일 읽어오기 (한글의 인코딩 방식을 지정해서 읽어오기)
		// using try with resource
		
		try(FileReader fr = new FileReader("d:/d_other/utf-8.txt");
			FileReader fr2 = new FileReader("d:/d_other/test_ansi.txt");
			FileInputStream fin = new FileInputStream("d:/d_other/utf-8.txt");
			FileInputStream fin2 = new FileInputStream("d:/d_other/test_ansi.txt");
			InputStreamReader isr = new InputStreamReader(fin2, "MS949");) {
			
			
			// 인코딩 방식을 지정하지 않으면 기본 인코딩 방식으로 읽어온다.
			// 인코딩 방식 예시 
			
			// -MS949 ==> 원도우의 기본 한글 인코딩 방식(ANSI 방식과 같다)
			// -utf-8 ==> 유니코드 utf-8 인코딩 방식 
			// - us-ascii ==> 영문 전용 인코딩 방식  
					
			int c;
			
			while((c = isr.read()) != -1) {
				System.out.print((char)c );
			}
					
		}
			
	}// end of main
}// end of FileIOTest5
