package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*
	문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 		컴퓨터의 숫자는 난수를 이용하여 구한다.
 		(스트라이크는 S, 볼은 B로 출력한다.)
 	
 	예) 컴퓨터의 난수 => 9 5 7
 	실행예시 ) 
 	숫자 입력 >> 3 5 6 
 	3 5 6 ==> 1S 0B
 	숫자 입력 >> 7 8 9 
 	7 8 9 ==> 0S 2B
 	숫자 입력 >> 9 7 5 
 	9 7 5 ==> 1S 2B
 	숫자 입력 >> 9 5 7 
 	9 5 7 ==> 3S 0B
 	
 	4번쨰만에 맞췄습니다...
 */
public class BaseBallTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count=0;
		
		HashSet<Integer> comSet = new HashSet<Integer>();
		while(comSet.size() < 3) {
			comSet.add((int) (Math.random() * (9 - 1 + 1) + 1));
		}
//		System.out.println("정답 : " + comSet);
		ArrayList<Integer> dap = new ArrayList<Integer>(comSet);
		Collections.shuffle(dap); // 자료 섞기
//		System.out.println(dap);
		
		while(true) {	
			int S=0;
			int B=0;
			count++;
			System.out.println("숫자 입력 >> ");
			int num0 = sc.nextInt();
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(num0);
			list.add(num1);
			list.add(num2);
			
			for (int i = 0; i < dap.size(); i++) {
				if ( dap.get(i) == list.get(i)) {
					S++;
				} else {
					for (int j = 0; j < dap.size() ; j++) {
						if (dap.get(i) == list.get(j)){
							B++;
						}
					}
				}
			}
			System.out.println("스트라이크"+S+",볼"+B);
			if (S==3) {
				System.out.println("정답! "+count+"번만에 맞췄습니다.");
				break;
			}
		}
	}
}
