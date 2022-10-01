package javaiIOtest.kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    d:/d_other/ 폴더에 있는 '팽권.jpg' 파일을 
    d:/d_other/ 연습용/ 폴더에  '복사본_팽귄_jpg'파일로 복사하는 프로그램을 작성하시오.
 */



public class FileCopyTest {
	public static void main(String[] args) throws IOException{
			
		try(FileInputStream  fis = new FileInputStream("d:/d_other/pg.jpg");
			FileOutputStream fos = new FileOutputStream("d:/d_other/연습용/copy_pg.jpg");
				
			){
			
			int c; 
				
			while((c = fis.read() ) != -1) {
				
				fos.write(c);				
			}
		} 
	
		System.out.println("test");
		
		new Thread(() -> {
			 for(int i = 0; i< 10; i++) {
				 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }
			
		}).start();
		
		
	}// end of main 
	
} // end of FileCopyTest

