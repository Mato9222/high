package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class HotelTest2 {
	Scanner sc = new Scanner(System.in);
	HashMap<Integer, Room> rm = new HashMap<Integer, Room>();
	public static void main(String[] args) {
		HotelTest2 room = new HotelTest2();
		
		room.start();
	}

	private void start() {
		startPrint();
		roomnum();
		while(true) { 
			System.out.println(" 1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				checkIn();
				break;
			case 2:
				checkOut();
				break;
			case 3:
				roomList();
				break;
			case 4:
				System.out.println("*********************************************");
				System.out.println("       호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				return;
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
		
	}

	private void checkOut() {
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		int sel = sc.nextInt();
		Room r = rm.get(sel);
		if(!rm.containsKey(sel)) {
			System.out.println(sel+"호 객실은 존재하지 않습니다.");
			return;
			
		} else if (rm.get(sel).getName().equals("-")) { 
			System.out.println(r.getNum()+"호 객실에는 체크인 한 사람이 없습니다.");
			
		} else { /*if (!rm.get(sel).getName().equals("-")) { 
			String tq = rom1(sel);
			rm.put(sel, new Room(sel, tq, "-"));*/
			rm.get(sel).setName(null);
			System.out.println(r.getName()+"님 체크아웃을 완료하였습니다.");
			
		
		}
	}

	private void roomList() {
		listPrint();
		List<Integer> list = new ArrayList(rm.keySet());
		
		Collections.sort(list);
		for (Integer r : list) {
			Room r2 = rm.get(r);
			System.out.println(r2.getNum()+"\t"+r2.getKind()+"\t"+r2.getName());
		}
	}

	private void listPrint() {
		System.out.println("----------------------------------------------\r\n" + 
				"		현재 객실 상태\r\n" + 
				"----------------------------------------------\r\n" + 
				"방 번호	 방 종류	 투숙객 이름\r\n" + 
				"----------------------------------------------");
	}

	private void checkIn() {
		chPrint();
		System.out.println("방 번호 입력 >>");
		int sel = sc.nextInt();
		String name;
		Room r = rm.get(sel);
		
		if(!rm.containsKey(sel)) {
			System.out.println(sel+"호 객실은 존재하지 않습니다.");
			return;
			
		} else if (!rm.get(sel).getName().equals("-")) {
			System.out.println("객실은 이미 손님이 있습니다.");
			
		} else { 
			System.out.println("누구를 체크인 하시겠습니까?");
			name = sc.next();
//			String tq = rom1(sel);
//			rm.put(sel, new Room(sel, tq, name));
			rm.get(sel).setName(name);
			
			System.out.println(name+"님 체크인 완료");
			return;
		}
	}
	
	private String rom1(int n) {
		if (n >= 400) { 
			return "스위트룸";
		} else if (n >= 300 && n < 400) {
			return "더블룸";
		} else {
			return "싱글룸";
		}
	}
	
	private void roomnum() {
		int rnum = 0;
		String sw = "스위트룸";
		String d = "더블룸";
		String s = "싱글룸";
		String name = "-";
		for (int i =200 ; i <=400; i=i+100) {
			for (int j=1; j<=9;j++ ) {
				rnum = i+j; 
				if (rnum >= 400) {
					rm.put(rnum, new Room(rnum , sw, name));
				} else if (rnum >= 300 && rnum < 400) {
					rm.put(rnum, new Room(rnum , d, name));
				} else {
					rm.put(rnum, new Room(rnum , s, name));
				}
			}
		}
	}
	
	private void chPrint() { 
		System.out.println("\r\n" + 
				"----------------------------------------------\r\n" + 
				"   체크인 작업\r\n" + 
				"----------------------------------------------\r\n" + 
				" * 201~209 : 싱글룸\r\n" + 
				" * 301~309 : 더블룸\r\n" + 
				" * 401~409 : 스위트룸\r\n" + 
				"----------------------------------------------");
	}
	
	private void startPrint() { 
		System.out.println( 
				"*********************************************\r\n" + 
				"       호텔문을 열었습니다. 어서오십시요.\r\n" + 
				"*********************************************\r\n\n" + 
				"---------------------------------------------\r\n" + 
				"어떤 업무를 하시겠습니까?");
	}
}
	
class Room2 {
	private int num;
	private String kind;
	private String name;
	
	public Room2(int num, String kind, String name) {
		super();
		this.num = num;
		this.kind = kind;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
