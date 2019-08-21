package copy_;

public class StuVO {
	//Field
	//학번,이름,국어,영어,수학, 총점, 평균
	String sno, sname;
	int rno,skor,seng,smath;
	double stot,savg;
	
	public int getRno() {	return rno;	}
	public void setRno(int rno) { this.rno = rno; }
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSkor() {
		return skor;
	}
	public void setSkor(int skor) {
		this.skor = skor;
	}
	public int getSeng() {
		return seng;
	}
	public void setSeng(int seng) {
		this.seng = seng;
	}
	public int getSmath() {
		return smath;
	}
	public void setSmath(int smath) {
		this.smath = smath;
	}
	public double getStot() {
		return (double)skor+seng+smath;
	}
	public void setStot(double stot) {
		this.stot = stot;		
	}
	public double getSavg() {
		return getStot()/3.0;
	}
	public void setSavg(double savg) {
		this.savg = savg;
	}
	
	
	
}
