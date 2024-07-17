package kr.or.ddit.basic;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.or.ddit.util.MybatisUtil;
import kr.or.ddit.vo.LprodVO;
import oracle.net.ns.SessionAtts;

// jdbcTest 프로젝트의 JdbcTest05.java의 기능을 MyBatis용으로 변환
// (mapper파일명 : jdbc-mapper.xml)
// (namespace속성값 : jdbc)
public class jdbcToMybatis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		 * InputStream in = null; SqlSessionFactory sql = null;
		 * 
		 * try { in = Resources.getResourceAsStream
		 * ("kr/or/ddit/mybatis/config/mybatis-config.xml");
		 * 
		 * sql = new SqlSessionFactoryBuilder().build(in);
		 * 
		 * } catch (Exception e) { System.out.println("초기화 실패"); e.printStackTrace(); }
		 * finally { if ( in != null ) try { in.close(); } catch (IOException e) {} }
		 */
		
		SqlSession session = null;
		
//			System.out.println("Lprod_GU 입력 >> ");
//			String lprodGU = sc.next();
			
			
			try {
//				session = SqlSessionFactory.openSession();
				session = MybatisUtil.getSqlSession();
				
				//선생님코드
				int nextId = session.selectOne("jdbc.getNextId");
				
				String gu;
				int count=0;
				do {
					System.out.println("상품 분류 코드 입력 >> ");
					gu = sc.next();
					
					count = session.selectOne("jdbc.getLprodCount", gu);
					
					if (count > 0) {
						System.out.println("중복입니다.");
					}
				} while (count>0);
				
//				LprodVO slvo = session.selectOne("jdbc.selectLp",lprodGU);
				
//				if (slvo == null || lprodGU.equals( slvo.getLprod_gu())) {
//					System.out.println("Lprod_GU 가 이미 존재합니다.");
//				}

				System.out.println("Lprod_NM 입력 >> ");
				String nm = sc.next();
				
				// 만들어진 데이터들을 VO객체에 저장한다.
				LprodVO lvo = new LprodVO();
				lvo.setLprod_id(nextId);
				lvo.setLprod_gu(gu);
				lvo.setLprod_nm(nm);
				
				int cnt = session.insert("jdbc.insertLp",lvo);
				
				if (cnt > 0 ) {
					session.commit();
					System.out.println("성공");
				} else {
					System.out.println("실패");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (session != null) session.close();
			}
		
			
			
//		System.out.println("Lprod_NM 입력 >> ");
//		String lprodNM = sc.next();
		
//		LprodVO lvo = new LprodVO();
//		lvo.setLprod_gu(lprodGU);
//		lvo.setLprod_nm(lprodNM);
		
//		session = null;
//		
//		try {
//			session = sql.openSession();
//			
//			int insertCnt = session.insert("jdbc.insertLp",lvo);
//			
//			if (insertCnt > 0 ) {
//				session.commit();
//				System.out.println("insert 성공!!");
//			} else {
//				System.out.println("insert 실패...");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if(session != null) session.close();
//		}
		
	}
}
