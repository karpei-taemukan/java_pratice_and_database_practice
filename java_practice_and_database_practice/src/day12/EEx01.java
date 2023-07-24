package day12;

public class EEx01 {

/* 접근 제한자
 * 1. public : 모든 패키지, 모든 클래스에서 접근가능, 
 * 					클래스, 필드, 생성자, 메소드
 * 2. private: 다른 클래스에서는 접근이 불가능(같은 클래스는 접근 가능)
 * 					필드, 생성자, 메소드
 * 	3,4는 상속과 관련 
 * 
 * 3. protected: 다른 패키지에 있는 클래스에서는 접근 불가능 
 * 				-자식클래스에서는 접근이 가능
 * 
 * 4. default:  다른 패키지에 있는 클래스에서는 접근 불가능
 */
public int pubVal;
private int priVal;

void privals() {
	System.out.println(priVal);
}

protected int proVal;
int dftVal;


}
