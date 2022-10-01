package javaiIOtest.kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    d:/d_other/ 폴더에 있는 '팽권.jpg' 파일을 
    d:/d_other/ 연습용/ 폴더에  '복사본_팽귄_jpg'파일로 복사하는 프로그램을 작성하시오.
 */



public class FileCopyTest2 {
	public static void main(String[] args) throws IOException{
			
		File file = new File("d:/d_other/pg.jpg");
		
		if(!file.exists()) {
			System.out.println(file.getPath() + "파일이 없습니다.");
			System.out.println("복사작업 중단");
			return;
		}
		
		try {
			// 복사할 원본 파일을 읽어올 입력용 스트림 객체 생성 
			FileInputStream fin = new FileInputStream(file);
			
			//복사될 대상 파일에 쓰기할 출력용 스트림 객체 생성 
			FileOutputStream fos = new FileOutputStream("d:/d_other/연습용/복사본_pg.jpg");
			
			
			System.out.println("복사 시작");
			
			int data; // 읽어온 데이터가 저장될 변수 
			
			while((data = fin.read()) != -1) {
				fos.write(data);
			}

			//스트림 닫기 
			fin.close();
			fos.close();
			System.out.println("복사 완료...");
			
		}catch(IOException e) {}
		
	}// end of main 
	
} // end of FileCopyTest
