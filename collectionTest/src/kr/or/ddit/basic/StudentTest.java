package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 문제) 학번, 이름, 국어점수, 영어점수, 수학점수, 총점, 등수를 멤버로 갖는 Student클래스를 만든다.
        이 Student클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수만 매개변수로 받아서
        초기화 처리를 한다. (총점은 3과목 점수의 합계로 초기화 한다.)

        이 Student객체는 List에 저장하여 관리한다.

        List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 내부 정렬 기준을 구현하고,
        총점의 내림차순으로 정렬하는데 총점이 같으면 이름의 오름차순으로 정렬되는 외부 정렬 기준 클래스를
        작성하여 정렬된 결과를 출력하시오.

        (단, 등수는 List에 전체 데이터가 추가된 후에 저장되도록 한다.)
*/
public class StudentTest {
	// 등수를 구하는 메서드
	public void createRanking(ArrayList<Student> sList) {
		for (Student std1 : sList) { // 기준 데이터를구하기 위한 반복문
			int rank1 = 1;	// 처음에 1등으로 초기화해 놓고 시작한다.
			
			for (Student std2 : sList) { //비교 대상을 나타내는 반복문
				//기준 보다 비교 대상이 크면 등수를 증가시킨다.
				if(std1.getSum() < std2.getSum() ) {
					rank1++;
				}
			}
			//구해진 등수를 Student 객체의 rank 변수에 저장한다.
			std1.setRank(rank1);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Student> sList = new ArrayList<Student>();

		sList.add(new Student(1,"홍길동", 87,93,79));
		sList.add(new Student(5,"이순신", 80,83,89));
		sList.add(new Student(9,"성춘향", 83,92,99));
		sList.add(new Student(3,"강감찬", 85,94,75));
		sList.add(new Student(6,"일지매", 93,87,79));
		
		System.out.println("정렬 전");
		for (Student student : sList) {
			System.out.println(student);
		}
		Collections.sort(sList);
		
		System.out.println("내부 정렬 후");
		for (Student student : sList) {
			System.out.println(student);
		}
		System.out.println("--------------------------------------");
		
		Collections.sort(sList, new sumsort());
		
		System.out.println("총점 정렬 후");
		for (Student student : sList) {
			System.out.println(student);
		}
		
		System.out.println();
		System.out.println("랭크 후 ");
//		for(int i = 0; i<sList.size(); i++ ) {
//			sList.get(i).setRank(i+1);
//			
//			System.out.println(sList.get(i));
//		}
//		
//		createRanking(sList);
		
		for (Student student : sList) {
			int rank = 1;
			for (Student student2 : sList) {
				if(student.getSum() < student2.getSum()) {
					rank++;
				}
				student.setRank(rank);
			}
			System.out.println(student);
		}
	}
}

	

class sumsort implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getSum() > o2.getSum()) {
			return -1;
		} else if (o1.getSum() < o2.getSum()) {
			return 1;
		} else if (o1.getSum() == o2.getSum()) {
			return o1.getName().compareTo(o2.getName());
		} else {
			return 0;
		}
	}
	
}
	
	
class Student implements Comparable<Student>{
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int sum;
	private int rank;
	
	public Student(int no, String name, int kor, int eng, int math) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.sum = kor+eng+math;
		this.rank = rank;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "student [no=" + no + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
				+ sum + ", rank=" + rank + "]";
	}

	
	@Override
	public int compareTo(Student o) {
		if (this.getNo() > o.getNo()) {
			return 1;
		} else if (this.getNo() < o.getNo()) {
			return -1;
		} else {
			return 0;
		}
	}
//	return Integer.compare(this.getNum(), std.getNum());
}
