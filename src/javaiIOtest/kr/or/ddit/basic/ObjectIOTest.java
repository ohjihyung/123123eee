package javaiIOtest.kr.or.ddit.basic;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
    직렬화 : 객체를 연속적인 데이터로 변환하는 것 
    반대과정 : 역직렬화
    
    조건 : 객체의 모든 인스턴스변수의 값을 저장한다.
 */

public class ObjectIOTest {

	public static void main(String[] args) {
		
		Member m1 = new Member("홍길도", "1234", 12);
		Member m2 = new Member("김하구", "14234", 20);
		Member m3 = new Member("치치", "1223164", 23);
		Member m4 = new Member("부대지개", "3sda4", 42);
		
		
		
		try {
			//객체를 파일에 저장
			FileOutputStream fos = new FileOutputStream("D:/d_other/memObj.bin");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oout = new ObjectOutputStream(bos);
			
			//쓰기작업 
			System.out.println("객체 저장하기 시작 ");
			oout.writeObject(m1);
			oout.writeObject(m2);
			oout.writeObject(m3);
			oout.writeObject(m4);
			oout.writeObject(null); // 마지막에 null을 추가하여 EOFException 방지
			System.out.println("객체 저장 작업 끝");
			
			oout.close();
			
			
		//==============================================================
			
		}catch(IOException e) { e.printStackTrace();}
		
		
		
		try {
			
			//저장한 객체를 읽어와 그 내용을 화면에 출력 한번에  		
			ObjectInputStream oin = new ObjectInputStream(
					new BufferedInputStream(
						new FileInputStream("D:/d_other/memObj.bin")
						)
					);
	
			Object obj;  // 읽어온 객체를 저장할 변수 
			System.out.println("객체 읽기 작업 시작 ..");
			
			// readObject()메서드가 데이터를 끝까지 다읽어오면 EOF Exception이 발생한다.
			while((obj = oin.readObject()) != null) {
				//읽어온 데이터를 원래의 객체형으로 형변환 후 사용 
				Member mem = (Member)obj;
				System.out.println("----------------------------------");
				System.out.println("이름 : " + mem.getName());
				System.out.println("비밀번호 : " + mem.getPassword());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("----------------------------------");
			}
			
			oin.close();
		}catch(EOFException e) {
			System.out.println("정상완료");
		}
		catch (IOException e) {
		   e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


class Member implements Serializable{


	// transient == > 직렬화가 되지 않을 멤버변수에 지정
	// 참조변수 -- null  숫자유형 변수 -- 0
	private String name;
    private transient String password; // 직렬화 대상에서 제외
	private int age;
	
	
	Member(String name, String pass, int age){
		this.name = name;
		this.password = pass;
		this.age = age;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	 
	
	
	
}