package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 	문제1) 5명의 사람 이름을 입력받아 ArrayList에 저장한 후에
 		이들 중에서 '김'씨 성의 이름을 모두 출력하시오.
 		(단, 입력은 Scanner객체를 이용한다.)
 	문제2) 5명의 별명을 입력받아 ArrayList에 저장하고 
 		이들 중에서 별명의 길이가 제일 긴 별명을 출력하시오.
 		(단, 각 별명의 길이는 모두 다르게 입력한다.)
 	문제3) '문제2'에서 입력하는 별명의 길이가 같은 것이 있을수 있을 때
 		결과를 출력하시오.
 */
public class ArrayListTest02 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayListTest02 obj = new ArrayListTest02();

//		obj.namekim();
//		obj.niksize();
		obj.sizeeq();
	}

	private void sizeeq() {
		System.out.println("별명을 입력하세요.");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(sc.next());
		list2.add(sc.next());
		list2.add(sc.next());
		list2.add(sc.next());
		list2.add(sc.next());

		String name = "";
		for (String str : list2) {
			if (name.length() < str.length()) {
				name = str;
			}
		}
			
		for (String str2 : list2) {
			if (name.length() == str2.length()) {
			System.out.println(str2);
			}
		}
	}

	private void niksize() {
		System.out.println("별명을 입력하세요.");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add(sc.next());
		list2.add(sc.next());
		list2.add(sc.next());
		list2.add(sc.next());
		list2.add(sc.next());

		String name = "";
		for (String str : list2) {
			if (name.length() < str.length()) {
				name = str;
			}
		}
		System.out.println(name);
	}

	private void namekim() {
		System.out.println("이름을 입력하세요.");

		ArrayList<String> list1 = new ArrayList<String>();
		for (int i = 1; i<=5; i++ ) {
			System.out.println(i + "번째 이름 : ");
			list1.add(sc.next());
		}
		for (int i = 0; i< list1.size();i++) {
//			if(list1.get(i).substring(0,1).equals("김") ) {
//				System.out.println(list1.get(i));
//			} 1번방법
//			if (list1.get(i).charAt(0)=='김') {
//				System.out.println(list1.get(i));
//			} 2번방법
//			if( list1.get(i).startsWith("김")) {
//				System.out.println(list1.get(i));
//			} 3번 방법
			if (list1.get(i).indexOf("김") == 0 ) {
				System.out.println(list1.get(i));
			} //4번 방법
		}
//		list1.add(sc.next());
//		list1.add(sc.next());
//		list1.add(sc.next());
//		list1.add(sc.next());
//		list1.add(sc.next());
//		
//		for (String str : list1) {
//			if (str.contains("김")) {
//				System.out.println(str);
//			}
//		}

	}
}
