package javaiIOtest.kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferIOTest01 {
	
	public static void main(String[] args) {
		
		//입출력 성능 향상을 위해 Buffered 스트림을 사용한다
		
		try {
			FileOutputStream fout = new FileOutputStream("d:/d_other/buffered.txt");
			
			//버퍼크기가 5인 버퍼 스트림 객체 생성
			// 버퍼크기를 지정하지 않으면 기본 크기는 8kb(8192byte)가 된다.
			BufferedOutputStream bos = new BufferedOutputStream(fout , 5);
			
			for(int i = '1'; i<= '9'; i++) {
				bos.write(i);
			}
			
			bos.flush(); // 버퍼에 남아있는 데이터를 강제로 모두 출력 
			
			bos.close(); // 보조스트림을 닫으면 보조스트림에 사용한 기반이 되는 스트림도 자동으로 닫힌다.
			
			System.out.println("작업끝");
			
			
		}catch(IOException e){}
		
		
	}
	
	
}
