package diet;

public class DietSelectVO2 {
	//Field
	int DS_NO,DSF_NO,DSF_CALORIE,DSF_TOT;
	String DSF_NAME, DS_DATE;

	
	//Constructor
	//Method
	
	public int getDS_NO() {
		return DS_NO;
	}
	public void setDS_NO(int dS_NO) {
		DS_NO = dS_NO;
	}
	public int getDSF_NO() {
		return DSF_NO;
	}
	public void setDSF_NO(int dSF_NO) {
		DSF_NO = dSF_NO;
	}
	public int getDSF_CALORIE() {
		return DSF_CALORIE;
	}
	public void setDSF_CALORIE(int dSF_CALORIE) {
		DSF_CALORIE = dSF_CALORIE;
	}
	public int getDSF_TOT() {
		return (int)DSF_CALORIE++;
	}
	public void setDSF_TOT(int dSF_TOT) {
		DSF_TOT = dSF_TOT;
	}
	public String getDSF_NAME() {
		return DSF_NAME;
	}
	public void setDSF_NAME(String dSF_NAME) {
		DSF_NAME = dSF_NAME;
	}
	public String getDS_DATE() {
		return DS_DATE;
	}
	public void setDS_DATE(String dS_DATE) {
		DS_DATE = dS_DATE;
	}
}
