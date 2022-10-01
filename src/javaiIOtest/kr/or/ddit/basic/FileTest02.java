package javaiIOtest.kr.or.ddit.basic;

import java.io.File;

public class FileTest02 {
	public static void main(String[] args) {
		
		
		File f1 = new File("d:/d_other/test.txt");
		
		
		// 크기는 byte 단위로 나온다.
		System.out.println(f1.getName() + "의 크기 " + f1.length() + "bytes"); 
		
		//파일의 경로를 나타냄 
		System.out.println( "path : "+ f1.getPath());
		System.out.println( "Absolutepath : "+ f1.getAbsolutePath()); // 절대경로
		
		//현재 프로그램이 실행 중인 경로 찾기 
		//File f2 = new File("");
		File f2 = new File(".");
		System.out.println( "path : "+ f2.getPath());
		System.out.println( "Absolutepath : "+ f2.getAbsolutePath()); // 절대경로
		
		System.out.println("---------------------------------------------");
		
		if(f2.isFile()){
			System.out.println(f2.getName() + "은 파일입니다");
		}else if(f2.isDirectory()) {
			System.out.println(f2.getName() + "은 디렉토리입니다");
		}else {
			System.out.println(f2.getName() + "는 뭘까요???");
		}
		

		
		File f3 = new File("d:/d_other/sample.exe");
		System.out.println("---------------------------------------------");
		
		// new File("위치/정보") 가 있어야만 아래에서 판별가능하다
		// sample.exe 가없으므로 아래 코드는 뭘까요가 나온다.
		if(f3.isFile()){
			System.out.println(f3.getName() + "은 파일입니다");
		}else if(f3.isDirectory()) {
			System.out.println(f3.getName() + "은 디렉토리입니다");
		}else {
			System.out.println(f3.getName() + "는 뭘까요???");
		}
		
		
		
		
		
		
		
		
		
		
	}
}
