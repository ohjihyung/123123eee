package javaiIOtest.kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 *  1) 6. '전화번호 저장' 메뉴를 추가하고 구현
 *     (저장파일명 : phoneData.dat) 
 *  
 *  2) 프로그램이 시작될때 저장된 파일이 있으면 저장된 파일의 데이터를 읽어와서
 *  	Map에 셋팅한 후 사용
 *
 *  3) 프로그램을 종료할 때 Map의 데이터가 변경되거나 추가 또는 삭제되면 저장 후 종료되도록한다.
 */
public class PhoneBookTest2{
	private Scanner sc;
	private Map<String, Phone2> tb; //전화번호부  
	private String fileName = "d:/d_other/phoneData.dat";
	private boolean dataChange = false; //데이터가 변경되었는지 여부를 나타내는 변수
	
	//생성자
	public PhoneBookTest2() {
		tb = load();
		if(tb == null) {
			tb = new HashMap<String, Phone2>();
		}
		sc = new Scanner(System.in);
		
	}
	
	
	public static void main(String[] args)  {
		
		new PhoneBookTest2().start();
	
	}

	private void start() {
		
		System.out.println("===============================================");
		System.out.println("  전화번호 관리 프로그램(파일로 저장됨)");
		System.out.println("===============================================");
		while(true) {
			
			int choose = displayMenu();
			switch(choose) {
			case 1:
				createPB();
				break;
			case 2:
				modifyPB();
				break;
			case 3:
				deletePB();
				break;
			case 4:
				searchPB();
				break;
			case 5: 
				PrintPB();
				break;
			case 6:
				savePB();
				 break;
			case 0:
				if(dataChange == true) {
					System.out.println("변경된 내용을 저장합니다...");
					savePB();
				}
				System.out.println("프로그램을 종료");
				return;
			default : 
				System.out.println("잘못입력하셧습니다");
				System.out.println("다시 선택");
			}
		}
		
		
	}

	//전화번호 정보가 저장된 파일을 읽어오는 메서드 
	@SuppressWarnings("unchecked")
	private HashMap<String, Phone2> load(){
		
		HashMap<String, Phone2> pMap = null; // 읽어온 데이터가 저장될 변수
		
		File file = new File(fileName);
		if(!file.exists()) { //저장된 파일이 없으면
			return null;
		}
		// 저장된 파일이 있으면 
		
		ObjectInputStream oin = null;
		try {
			// 객체 입력용 스트림 객체 생성 
			oin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			
			// 파일에서 데이터를 읽어온다 .
			pMap = (HashMap<String, Phone2>)oin.readObject();
			
			
			
		}catch(IOException e) {
			
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//스트림 닫기 
			if(oin!=null) try {oin.close();} catch(IOException e) {}
		}
		
		return pMap;
		
	}
	
		
	//전화번호 정보를 파일로 저장하는 메서드 
	private void savePB(){
		ObjectOutputStream oout = null;
		
		try {
			// 객체를 출력할 스트림 객체 생성 
			oout = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(fileName)));
			
			// 객체 저장하기 --> Map 객체 자체를 저장 
			
			oout.writeObject(tb);
			System.out.println("저장 완료");
			
			dataChange = false;
			
			
		}catch(IOException e) {}
		
		finally {
			if(oout!=null)
				try {oout.close();} catch (IOException e) {
					
					e.printStackTrace();
				}
		}
			
	}


	private int displayMenu() { // 매뉴선택 창
	
		System.out.println("\r\n" + 
				"  메뉴를 선택하세요.");
		System.out.println(
				"  1. 전화번호 등록\r\n" + 
						"  2. 전화번호 수정\r\n" + 
						"  3. 전화번호 삭제\r\n" + 
						"  4. 전화번호 검색\r\n" + 
						"  5. 전화번호 전체 출력\r\n" + 
						"  6. 전화번호 저장 \r\n" +
				"  0. 프로그램 종료");
		System.out.println("--------------------------");
		System.out.print("번호 입력>>");
		return sc.nextInt();
		
	}

	private void searchPB() { // 검색
		String name;
		System.out.print("찾을이름을 입력하세요>>");
		name = sc.next();
		if(tb.containsKey(name)) {
			System.out.println("==============================================================");
			System.out.println("이름 : " + tb.get(name).getName() + "  전화번호 : " + tb.get(name).getTel() + "  주소 : " + tb.get(name).getAdd());
			System.out.println("==============================================================");
		}
		else System.out.println("없는 이름입니다.");
		
	}

	private void deletePB() { // 삭제
		 
		String name;
		System.out.print("삭제할 이름을 입력하세요>>");
		name = sc.next();
		if(tb.containsKey(name)) {
			tb.remove(name);
			System.out.println("삭제완료");
		}
		else System.out.println("없는 이름입니다.");
		
		dataChange = true;
		
	}

	private void modifyPB() { // 수정
		String name;
		System.out.print("수정할 이름을 입력하세요>>");
		name = sc.next();
		if(tb.containsKey(name)) {
			System.out.println("수정할 정보를 입력하세요 1. 이름, 2.전화번호 3.주소");
			int input = sc.nextInt();
			switch(input) {
			case 1:
				System.out.println("바꿀이름을 입력");
				String re = sc.next();
				if(tb.containsKey(re)) {
					System.out.println("이름이 존재해서 수정 불가!");
					break;
				}
				tb.get(name).setName(re);
				tb.put(re, tb.get(name));
				//기존에 있던 사람이름 제거 
				tb.remove(name);
				do_finally();
				
				break;
			case 2: 
				System.out.println("바꿀 번호 입력 ");
				 re = sc.next();
				tb.get(name).setTel(re);
				do_finally();
				break;
			case 3:
				System.out.println("바꿀 주소 입력");
				 re = sc.next();
				 tb.get(name).setAdd(re);
				 do_finally();
				break;
			default :
			System.out.println("잘못입력");
			
			}
			
		}
		else System.out.println("없는 정보");
		
		dataChange = true;
		
	}

	private void do_finally() { //수정시 출력되는 문자 
		System.out.println("완료!");
		
	}


	private void PrintPB() { // 전체출력

		System.out.println( "=======================================\r\n" + 
							"번호   이름       전화번호         주소\r\n" + 
							"=======================================");		
		Set<String> phonekeyset = tb.keySet();
		
		if(phonekeyset.size() == 0 ) {
			System.out.println("등록된 전화번호가 하나도 없습니다");
		}else {
			int cnt = 0;
			Iterator<String> keyIter = phonekeyset.iterator();
			while(keyIter.hasNext()) {
				cnt++;  // 번호증가
				String key = keyIter.next(); //키값 구하기  
				Phone2 p = tb.get(key); // 키값을 이용하여 value 값(Phone2)객체 구하기
				System.out.println(cnt +"\t" + p.getName() + "\t" + p.getTel() + "\t" + p.getAdd());
				
			}
		}
		System.out.println("==========================================");
		System.out.println(" 출력 끝....");
		
		
	}
		
	private void createPB() {  // 생성
		
		String name, tel, add;
		System.out.println(" 새롭게 등록할 전화번호 정보를 입력하세요.");
		
		System.out.print("이름>>");
		name = sc.next();
		
		//입력되어있는 사람인지 check
		if(tb.containsKey(name)) {
			System.out.println("이미 있는 사람입니다 ");
			return;
		}
		
	
		System.out.print("전화번호>>");
		tel = sc.next();
		sc.nextLine(); // 입력버퍼 없에준다.
		System.out.print("주소>>");
		add = sc.nextLine();
		
	
		tb.put(name, new Phone2(name, add, tel)); // map에다가 새로 저장 
		dataChange = true;
		//System.out.println(tb.get(name).getName());
		//System.out.println(tb);
	  
		/*
		  	Scanner 객체의 next(), nextInt(), 등 
		  	   => 사이띄기, Tab키, Enter 키를 구분문자로 분리해서 분리된
		  	      자료만 읽어간다.
		  	      
		  	Scanner 객체의 nextLine() 
		  	    ==> 한 줄 단위로 입력한다. 즉, 자료를 입력하고 enter키를 누르면 
		  	    Enter키값까지 읽어가서 Enter키값을 뺀 나머지를 반환한다.
		  
		 */
		
		
	}
}

class Phone2  implements Serializable{
	
	private String name, add, tel;
	
	
	public Phone2(String name, String add, String tel) {
		this.name = name;
		this.add = add;
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAdd() {
		return add;
	}
	
	public void setAdd(String add) {
		this.add = add;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	@Override
	public String toString() {
		return "Phone2 [name=" + name + ", add=" + add + ", tel=" + tel + "]";
	}
	
	
}

