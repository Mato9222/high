package kr.or.ddit.basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class PhoneBookTest {
	HashMap<String, Phone> map = new HashMap<String, Phone>();
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		PhoneBookTest obj = new PhoneBookTest();
		obj.start();
	}
	private void start() {
		while(true) {
			System.out.println("1. 전화번호 등록\r\n" + 
								"2. 전화번호 수정\r\n" + 
								"3. 전화번호 삭제\r\n" + 
								"4. 전화번호 검색\r\n" + 
								"5. 전화번호 전체 출력\r\n" + 
								"0. 프로그램 종료");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				phoneAdd();
				break;
			case 2:
				phoneUpdate();
				break;
			case 3:
				phoneDelete();
				break;
			case 4:
				phoneSelect();
				break;
			case 5:
				phoneList();
				break;
			case 0:
				return;
			default:
				System.out.println("잘못 입력하셨습니다.");
				break;
			}
		}
		
	}
	
	private void phoneSelect() {
		System.out.println("검색할 이름을 입력해 주세요.");
		String iname = sc.next();
		
		if(!map.containsKey(iname)) { 
			System.out.println(iname+"씨의 전화번호 정보가 없습니다.");
			return;
		}
		
		Phone ph = map.get(iname);
		
//		String name = ph.getName();
//		String phone = ph.getPhone();
//		String addr = ph.getAddr();
//		
//		System.out.println("이름\t전화번호\t\t주소");
//		System.out.println(name+"\t"+phone+"\t"+addr);
		
		System.out.println(" 이름  : " + ph.getName());
		System.out.println(" 전화번호  : " + ph.getPhone());
		System.out.println(" 주소  : " + ph.getAddr());
	}
	
	private void phoneDelete() {
		System.out.println("삭제할 이름을 입력해 주세요");
		String name = sc.next();
		map.remove(name);
	}
	
	private void phoneUpdate() {
//		System.out.println("수정할 이름을 입력해 주세요.");
//		String iname = sc.next();
//		
//		System.out.println("이름 : ");
//		String name = sc.next();
//		
//		System.out.println("전화번호 : ");
//		String phone = sc.next();
//		
//		System.out.println("주소");
//		String addr = sc.next();
//		
//		map.put(name, new Phone(name,phone,addr));
		System.out.println("수정할 전화번호 정보를 입력하세요");
		System.out.println("이름 : ");
		String name = sc.next();
		
		//해당 이름이 등록되어 있지 않으면 수정 작업을 못한다.
		if(!map.containsKey(name)) { 
			System.out.println(name+"씨의 전화번호 정보가 없습니다.");
			return;
		}
		System.out.println("새로운 전화번호 >> ");
		String newTel = sc.next();
		sc.nextLine();	//입력 버퍼 비우기
		
		System.out.println("새로운 주소 >> ");
		String newAddr = sc.next();
		
		// 같은 key값에 새로운 전화번호 정보를 저장한다. ==> 수정 작업
		map.put(name, new Phone(name, newTel, newAddr));
		
		System.out.println(name+"의 전화번호 수정 완료!");
		
		
		
	}
	
	private void phoneList() {
//		System.out.println("번호\t이름\t전화번호\t\t주소");
//		int i =1;
//		for (Phone string : map.values()) {
//			System.out.printf("%d\t%s\t%s\t\t%s\n",i++,string.getName(),string.getPhone(),string.getAddr());
//		}
		// Map 의 전체 key값 정보 구하기
		Set<String> keySet = map.keySet();
		
		System.out.println("-----------------------------------");
		System.out.println("번호\t이름\t전화번호\t\t주소");
		System.out.println("-----------------------------------");
		if(keySet.size()==0) {
			System.out.println( "등록된 정보가 없습니다.");
		} else { 
			int num = 0;
			for (String name : keySet) {
				num++;
				// key값 (이름)을 이용하여 value값(Phone객체)를 구한다.
				Phone p = map.get(name);
				System.out.println(num+"\t"+p.getName()+"\t"+
								p.getPhone()+"\t"+p.getAddr());
			}
		}
		System.out.println("-----------------------------------");
		System.out.println("출력 완료");
		
	}

	private void phoneAdd() {
		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
		
		System.out.println("이름 : ");
		String name = sc.next();
		if(map.containsKey(name)) {
			System.out.println(name+"씨 전화번호가 있습니다." );
			System.out.println("등록작업을 마칩니다.");
			return;
		}
		
		System.out.println("번호 : ");
		String phone = sc.next();
		sc.nextLine();	// 입력 버퍼 비우기
		
		System.out.println("주소 : ");
		String addr = sc.nextLine();
		
		map.put(name, new Phone(name, phone, addr));
		
		System.out.println(name+" 전화번호 등록 완료!!");
	}
}

/*
    Scanner의 메서드들의 특징 
   - next(), nextInt(), nextDouble() ...
    	==> 띄어쓰기, Tab, Enter키를 구분문자로 분리해서 분리된 자료만 읽어간다.
   - nextLine()
   		==> 한 줄 단위로 읽어간다.
   			즉, 자료를 입력하고 Enter키를 누르면 Enter키까지 읽어가서 
   				Enter키를 뺀 나머지 데이터를 반환한다.
 */

class Phone {
	private String name;
	private String phone;
	private String addr;
	
	public Phone(String name, String phone, String addr) {
		super();
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}


	@Override
	public String toString() {
		return "Phone [name=" + name + ", phone=" + phone + ", addr=" + addr + "]";
	}
	
}	
