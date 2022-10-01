package javaiIOtest.kr.or.ddit.basic;


import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest4 {
	
	
	public static void main(String[] args)  {
	
	// 사용자가 입력한 내용을 그대로 파일로 저장 
	
		try {
			//System.in ==> 콘솔(표준 입출력 장치)의 입력장치 
//			System.out.print("한문자 입력 >");
//			int c = System.in.read();
//			System.out.println("입력한 문자 : " + (char)c);
	
			// 입력용 byte 기반의 스트림을 문자 기반의 스트림으로 변환해 주는 스트림 객체 생성
			InputStreamReader  isr = new InputStreamReader(System.in);
			
			//파일 출력용 문자기반 스트림 객체 생성 
			FileWriter fw = new FileWriter("d:/d_other/testchar.txt");
			
			System.out.println("아무 내용이나 입력하세요 (입력의 끝은 ctrl + z ) ");
			
			int c;
			// 콘솔에서 입력할 때 입력의 끝은 'ctrl + z 키 '
			while((c = isr.read()) != -1) {
				fw.write(c);			
			}

			isr.close();
			fw.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		//using try - with - resource
		
		
	
		
		
		
		
		
	}// end of main
}// endof FileIOTest4
