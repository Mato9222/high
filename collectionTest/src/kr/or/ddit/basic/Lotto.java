package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Lotto {
	 Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		Lotto obj = new Lotto();
		obj.start();
	}

	private void start() {
		while (true) {
			System.out.println("1. Lotto 구입 \n2. 프로그램 종료");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				System.out.println("Lotto 구매 시작 \n금액 입력 : ");
				int money = sc.nextInt();
				if (money < 1000) {
					System.out.println("금액이 적습니다. 로또번호 구입 실패!!!");
				} else if (money > 100000) {
					System.out.println("금액이 너무 많습니다. 로또번호 구입 실패!!!");
				} else {
					autoLotto(money);
				}
				break;
			case 2:
				System.out.println("감사합니다");
				return;
			default:
				System.out.println("번호를 잘못입력했습니다.\n다시입력해주세요");
			}
		}
	}
	

	private void autoLotto(int money) {
		int Lotto = money / 1000;
		int g = money % 1000;
		HashSet<Integer> autoLotto = new HashSet<Integer>();

		for (int i = 0; i < Lotto; i++) {
			while (autoLotto.size() < 6) {
				autoLotto.add((int) (Math.random() * 45 + 1));
			}
			
			ArrayList<Integer> list = new ArrayList<Integer>(autoLotto);
			Collections.sort(list);
			
			System.out.println(i+1+"번째 로또번호 :" + list);
			autoLotto.clear();
		}
		System.out.println("받은 금액은 : "+ money + "원, 거스름 돈 : " + g +"원 입니다.");
		
	}
}
