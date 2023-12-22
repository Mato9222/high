package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * 문제3) '문제2'에서 입력하는 별명의 길이가 같은 것이 있을수 있을 때
 		결과를 출력하시오.
 */
public class ArrayListTest04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> aliasList = new ArrayList();
		
		System.out.println("다른 길이의 별명을 입력 : ");
		for (int i=1; i<=5;i++) { 
			System.out.println(i + "번째 별명 : ");
			String alias = sc.nextLine();
			aliasList.add(alias);
		}
		// 제일 긴 별명의 길이가 저장될 변수 선언, 첫번째 데이터으 길이로 초기화
		int maxLength = aliasList.get(0).length();
		
		for (int i = 0; i < aliasList.size(); i++) {
			if(maxLength < aliasList.get(i).length()) {
				maxLength = aliasList.get(i).length();
			}
		}
		for (String alias : aliasList) {
			if(alias.length() == maxLength) {
				System.out.println(alias);
			}
		}
	}
}
