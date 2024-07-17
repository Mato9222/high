package kr.or.ddit.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
		  - Stack의 명령 ==> FILO (선입후출) LIFO(후입선출)의 자료구조
		  			 
		  - Queue ==> FIFO (선입선출)의 자료구조 
 */ 
public class StackQueueTest {
	public static void main(String[] args) {
		/*
		 * 1. 자료 입력 : push(입력값) 
		 * 2. 자료 출력 : pop() ==> 자료를 꺼내온 후 꺼내온 자료를 Stack에서 삭제한다.
		 *			  peek() ==> 삭제없이 자료를 꺼내온다. 검사할때 쓴다.
		 * 사용하는곳 - 컨트롤z, 웹 앞/뒤로가기, 
		 */
		 Stack<String> stack = new Stack<String>(); // Srack 클래스를 이용하기. 동기화로 인해 무거운 편이다.
//		LinkedList<String> stack = new LinkedList<String>();
		
		stack.push("홍길동");
		stack.push("일지매");
		stack.push("변학도");
		stack.push("강감찬");
		
		System.out.println("stack ==> " + stack);
		
		String data = stack.pop();
		System.out.println("꺼내온 값 : " + data);
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("stack ==> " + stack);
		System.out.println();
	
		stack.push("성춘향");
		System.out.println("추가 후 stack ==> " + stack);
		
		System.out.println("꺼내온 값 : " + stack.pop());
		System.out.println("stack ==> " + stack);
		System.out.println();
		
		System.out.println("삭제없이 꺼내온 값 : " + stack.peek());
		System.out.println("stack ==> " + stack);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		/*
		 * - Queue의 명령어
		 *  1. 자료 입력 : offer(입력값) 
		 *  2. 자료 출력 : poll() ==> 자료를 거내오고 꺼내온 자료를 Queue에서 삭제한다.
		 *  		   peek() ==> 삭제없이 자룔르 꺼내온다.
		 *  사용하는곳 - 프린터 
		 */
		Queue<String> queue = new LinkedList<String>();
		
		queue.offer("홍길동");
		queue.offer("일지매");
		queue.offer("변학도");
		queue.offer("강감찬");
		
		System.out.println("Queue ==> " + queue);
		
		String temp = queue.poll();
		System.out.println("꺼내온 값 : " + temp);
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("Queue ==> " + queue);
		
		queue.offer("성춘향");
		System.out.println("Queue ==> " + queue);
		
		System.out.println("꺼내온 값 : " + queue.poll());
		System.out.println("Queue ==> " + queue);
		
		System.out.println("삭제없이 꺼내온 값 : "+ queue.peek());
		System.out.println("Queue ==> " + queue);
		
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
//		isEmpty() ==> Collection에 자료가 없으면 ture, 있으면 false 반환
		stack.clear();
		queue.clear();
		System.out.println("스택이 비었는지 여부 : "+ stack.isEmpty());
		System.out.println("큐가 비었는지 여부 : "+ queue.isEmpty());
		
		
	}
}
