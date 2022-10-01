package javaiIOtest.kr.or.ddit.basic;
import java.io.FileReader;
import java.io.IOException;

public class FileIOTest3 {
	public static void main(String[] args)  {
	
		
		try {
			FileReader fr = new FileReader("d:/d_other/test.txt");
			
			int c ;
			
			while( (c = fr.read()) != -1) {
				System.out.print((char) c);
				
			}
			
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
