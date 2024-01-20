package kr.or.ddit.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mvc.util.DBUtil3;
import kr.or.ddit.mvc.util.MybatisUtil;
import kr.or.ddit.mvc.vo.MemberVo;
import oracle.net.ns.SessionAtts;

public class MemberDaoImpl implements IMemberDao {
	// 1번
	private static MemberDaoImpl member;
	// 2번
	private MemberDaoImpl() {}
	// 3번
	public static MemberDaoImpl getInstance() {
		if (member == null)  member = new MemberDaoImpl();

		return member;
	}

	@Override
	public int getMemberCount(String memId) {
		
		SqlSession session = null;
		
		int count = 0;
		try {
			session = MybatisUtil.getSqlSession();
				
			count = session.selectOne("member.selectId",memId);
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return count;
	}

	@Override
	public int insertMember(MemberVo memVo) {
		SqlSession session = null;
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
	
			cnt = session.insert("member.insertMem",memVo);
	
			if (cnt > 0) {
				session.commit();
				System.out.println("insert 작업 성공!! ");
			} else {
				System.out.println("insert 작업 실패..");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return cnt;
	}

	@Override
	public int deleteMember(String memId) {

		SqlSession session = null;
		
		int cnt = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.delete("member.deleteMem",memId);
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}	
		
		return cnt;
	}

	@Override
	public int updateMember(MemberVo memVo) {
		int cnt = 0;
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("member.updateMem",memVo);
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}

	@Override
	public List<MemberVo> getAllMember() {
		List<MemberVo> memList = null; // 반환값이 저장될 변수 선언
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();

			memList = session.selectList("member.allMember");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return memList;
	}

	@Override
	public int updateMem2(Map<String, String> param) {
		//key 정보 ==> 회원ID (memberId), 수정할 컬럼명(fieldName), 수정할 데이터(data)
		int cnt = 0;
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			cnt = session.update("member.selUpdate",param);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		return cnt;
	}
}
