package kr.or.ddit.mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mvc.service.IMemberService;
import kr.or.ddit.mvc.service.MemberServiceImpl;
import kr.or.ddit.mvc.util.MybatisUtil;
import kr.or.ddit.mvc.vo.MemberVo;

public class MemberController {
	// Service객체의 참조값이 저장될 변수 선언
	private IMemberService service;
	private Scanner sc;

	// 생성자
	public MemberController() {
		sc = new Scanner(System.in);
		service = MemberServiceImpl.getInstance();
	}

	public static void main(String[] args) {
		new MemberController().startMenu();
	}

	// 시작 메서드
	private void startMenu() {
		// 시작메서드
		while (true) {
			int choice = displayMenu();

			switch (choice) {
			case 1: // 추가
				insertMember();
				break;
			case 2: // 삭제
				deleteMember();
				break;
			case 3: // 수정
				updateMember();
				break;
			case 4: // 전체 출력
				displayAllMember();
				break;
			case 5: // 전체 출력
				updateMember2();
				break;
			case 0:
				System.out.println("작업을 마칩니다.");
				return;
			default:
				System.out.println("작업 번호를 잘못 입력했습니다.");
				System.out.println("다시 입력하세요.");
			}
		}
	}
	
	// 회원정보 수정 ==> 원하는 컬럼만 수정
	private void updateMember2() {
		   System.out.println();
		      System.out.println("수정할 회원 정보를 입력하세요");
		      System.out.print("회원 ID >>");
		      String memId = sc.next();

		      int count = service.getMemberCount(memId);
		      if (count == 0) {
		         System.out.println(memId + "은(는) 없는 회원입니다.");
		         System.out.println("수정 작업을 종료합니다");
		         return;
		      }
		      
		      int fieldNum;
		      String updateField = null; //수정할 컬럼명이 저장될 변수
		      String updateTitle = null; //수정할 내용의 제목이 저장될 변수
		      do {
		         System.out.println();
		         System.out.println("수정할 항목을 선택해주세요.");
		         System.out.println("1. 비밀번호");
		         System.out.println("2. 회원이름");
		         System.out.println("3. 전화번호");
		         System.out.println("4. 회원주소");
		         System.out.print("선택 >>");
		         fieldNum = sc.nextInt();
		         switch (fieldNum) {
		         case 1 : updateField = "mem_pass";
		                updateTitle = "비밀번호" ; break;
		         case 2 : updateField = "mem_name";
		                 updateTitle = "회원이름" ; break;
		         case 3 : updateField = "mem_tel";
		                updateTitle = "전화번호" ; break;
		         case 4 : updateField = "mem_addr";
		                updateTitle = "회원주소" ; break;
		         default :
		            System.out.println("수정할 항목을 잘못 선택했습니다. 다시 선택하세요.");
		         }
		      } while (fieldNum<1 || fieldNum>4);
		      sc.nextLine();// 입력 버퍼 비우기
		      System.out.println(); 
		      System.out.println("새로운" + updateTitle + " >> ");
		      String updateData = sc.nextLine();
		      
		      // 수정 작업에 사용할 데이터를 Map에 추가한다.
		      Map<String , String> pMap = new HashMap<String, String>();
		      pMap.put("memberID",memId);
		      pMap.put("fieldName", updateField);
		      pMap.put("data", updateData);
		      
		      int cnt = service.updateMem2(pMap);
		      
		      if(cnt > 0) {
		    	  System.out.println(" 성공 !");
		      } else {
		    	  System.out.println(" 실패 !");
		      }
		    		  
		      
	}

	private void displayAllMember() {
		List<MemberVo> memList = service.getAllMember();
		System.out.println();
		System.out.println("------------------------------------------------------");
		System.out.println(" 회원ID\t비밀번호\t회원이름\t전화번호\t\t회원주소");
		System.out.println("------------------------------------------------------");

		if (memList == null || memList.size() == 0) {
			System.out.println("회원이 없습니다.");
		} else {
			for (MemberVo memberVo : memList) {
				String id = memberVo.getMem_id();
				String pass = memberVo.getMem_pass();
				String name = memberVo.getMem_name();
				String tel = memberVo.getMem_tel();
				String addr = memberVo.getMem_addr();

				System.out.println(id + "\t" + pass + "\t" + name + "\t" + tel + "\t" + addr);
			}
		}
		System.out.println("------------------------------------------------------");

//		boolean chk = false;
//		
//		for (MemberVo memberVo : memList) {
//			chk = true;
//			String id = memberVo.getMem_id();
//			String pass = memberVo.getMem_pass();
//			String name = memberVo.getMem_name();
//			String tel = memberVo.getMem_tel();
//			String addr = memberVo.getMem_addr();
//			
//			System.out.println(id+"\t"+pass+"\t"+name+"\t"+tel+"\t"+addr);
//		}
//		if(!chk) {
//			System.out.println("회원정보가 없습니다.");
//		}
	}

	// 수정하는 메서드
	private void updateMember() {
		System.out.println();
		System.out.println("수정할 회원 정보를 입력하세요");
		System.out.print("회원 ID >>");
		String memId = sc.next();

		int count = service.getMemberCount(memId);
		if (count == 0) {
			System.out.println(memId + "는(은) 없는 회원입니다.");
			System.out.println("수정 작업을 종료합니다");
			return;
		}

		System.out.println("수정할 내용을 입력하세요.");
		System.out.print("새로운 비밀번호 >>");
		String newMemPass = sc.next();

		System.out.print("새로운 회원이름 >>");
		String newMemName = sc.next();

		System.out.print("새로운  전화번호 >>");
		String newMemTel = sc.next();

		sc.nextLine();// 버퍼비우기
		System.out.print("새로운 회원주소 >>");
		String newMemAddr = sc.nextLine();

		// 입력 받은 수정할 자료를 Vo객체에 저장한다.
		MemberVo memVo = new MemberVo();
		memVo.setMem_pass(newMemPass);
		memVo.setMem_name(newMemName);
		memVo.setMem_tel(newMemTel);
		memVo.setMem_addr(newMemAddr);
		memVo.setMem_id(memId);

		int cnt = service.updateMember(memVo);

		if (cnt > 0) {
			System.out.println("수정 성공!!");
		} else {
			System.out.println("수정 실패..");
		}
	}

	// 삭제 메서드
	private void deleteMember() {
		System.out.println();
		System.out.print("삭제할 회원 정보를 입력하세요 >> ");
		String memId = sc.next();

		int cnt = service.deleteMember(memId);

		if (cnt > 0) {
			System.out.println("삭제 성공!!");
		} else {
			System.out.println("삭제 실패..");
		}
	}

	// insert
	private void insertMember() {
		String id;
		int count=0;
			do {
				System.out.println("추가할 회원 정보를 입력하세요.");
				id = sc.next();
				count = service.getMemberCount(id);

				if(count > 0) {
					System.out.println("중복이다 이자식아");
				} 
				
			} while (count > 0) ;
			
			System.out.print("비밀번호 >>");
			String memPass = sc.next();

			System.out.print("회원이름 >>");
			String memName = sc.next();

			System.out.print("전화번호 >>");
			String memTel = sc.next();

			sc.nextLine(); // 입력 버퍼 비우기
			System.out.print("회원주소 >>");
			String memAddr = sc.nextLine();
			
			MemberVo mvo = new MemberVo();
			mvo.setMem_id(id);
			mvo.setMem_pass(memPass);
			mvo.setMem_name(memName);
			mvo.setMem_tel(memTel);
			mvo.setMem_addr(memAddr);
			
			service.insertMember(mvo);
			
		}
	// 메뉴를 출력하고 작업 번호를 입력 받아 반환하는 메서드
	private int displayMenu() {
		System.out.println();
		System.out.println("**********************************************");
		System.out.println("\t\t회원관리 프로그램");
		System.out.println("**********************************************");
		System.out.println("1. 자료 추가");
		System.out.println("2. 자료 삭제");
		System.out.println("3. 자료 수정");
		System.out.println("4. 전체 자료 출력");
		System.out.println("5. 자료 수정2"); // ==> 원하는 항목만 수정하기
		System.out.println("0. 작업 끝");
		System.out.println("----------------------------------------------");
		System.out.print("작업하실 번호를 입력해주세요 >>");
		return sc.nextInt();
	}
}
