package kr.or.ddit.mvc.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.vo.MemberVo;

/**
 * Service객체는 DAO에 만들어진 메서드를 원하는 작업에 맞게 호출하여 
 * 실행 결과를 받아오고, 받아온 결과를 Controller에게 보내주는 역할을 한다.
 *
 * 우리 시간에는 DAO의 interface와 구조가 같게 만든다.
 */
public interface IMemberService {
	/**
	 * MemberVo객체에 담겨진 자료를 insert하는 메서드
	 * 
	 * @param memVo DB에 insert 할 자료가 저장된 MemberVO객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int insertMember(MemberVo memVo); 
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원 정보를 삭제하는 메서드
	 * 
	 * @param memIO 삭제할 회원ID
	 * @return 작업 성공 : 1, 작업  실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVo객체 자료를 이용하여 DB에 update하는 메서드
	 * 
	 * @param memVo update할 회원 정보가 저장된 MemberVo객체
	 * @return 작업 성공 : 1, 작업 실패 : 0
	 */
	public int updateMember(MemberVo memVo);
	
	/**
	 * DB의 전체 회원 정보를 가져와서 List에 담아서 반환하는 메서드
	 * 
	 * @return MemberVo객체가 저장된 List객체
	 */
	public List<MemberVo> getAllMember();
	
	/**
	 * 회원 ID를 매개변수로 받아서 해당 회원 Id의 개수를 반환하는 메서드
	 * 
	 * @param memId 검색할 회원 ID
	 * @return 검색된 회원 ID의 갯수
	 */
	public int getMemberCount(String memId);

	/**
	 * Map의 정보를 이용하여 회원 정보 중 원하는 컬럼을 수정하는 메서드 
	 * key 정보 ==> 회원ID (memberId), 수정할 컬럼명(fieldName), 수정할 데이터(data)
	 * 
	 * @param param 회원ID, 수정할 컬럼명, 수정할 데이터가 저장된 Map객체
	 * @return 성공 1 ,실패 0
	 */
	public int updateMem2(Map<String, String> param);

	
}
