package javaiIOtest.kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FileTest03 {
	public static void main(String[] args) {
		
		FileTest03 test = new FileTest03();
		
		File file = new File("c:/windows");
		
		test.displayFileList(file);
		
		
	}
	
	
//디렉토리 정보를 갖고 있는 File 객체를 인수값으로 받아서 해당 디렉토리에 있는 
// 모든 파일과 디렉토리 목록을 출력하는 메서드
public void displayFileList(File dir) {
	if(!dir.isDirectory()) {System.out.println("디렉토리 (폴더)만 가능합니다"); return;}
	
	System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용");
	
	//해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구해서 가져온다.
	File[] files = dir.listFiles();
	
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm"); // 시간 패턴을 만들어준다
	
	// 가져온 파일과 디렉토리 목록 개수만큼 반복
	
	for(File f : files) {
		String fileName = f.getName();
		String attr = ""; // 파일 속성을 나타낼 변수(읽기, 쓰기, 히든, 디렉토리를 구분해서 나타낸다.)ㄴ
		String size = ""; // 파일크기 
		if(f.isDirectory()) {
			attr  = "<DIR>";
		}else {
			attr = f.canRead() ? "R" : "";
			attr += f.canWrite() ? "W" : "";
			attr += f.isHidden() ? "H" : "";
			
			size = fileName.length() +"";
		}
		
		System.out.printf("%s %5s %12s %s\n",df.format(new Date(f.lastModified())), attr,size, fileName);
		
		
	}
	
}
	
}//end of FileTest03


