package kr.co.kosmo.mvc.vo;

/*
 MANUM	NUMBER
MAID	VARCHAR2(30 BYTE)
MAPWD	VARCHAR2(20 BYTE)
MAPHONE	VARCHAR2(50 BYTE)
MAEMAIL	VARCHAR2(100 BYTE)
MADATE	DATE
 */

public class AdminDTO {
	
	private int manum;
	private String maid, mapwd, maphone, maemail, sysdate;
	
	public int getManum() {
		return manum;
	}
	public void setManum(int manum) {
		this.manum = manum;
	}
	public String getMaid() {
		return maid;
	}
	public void setMaid(String maid) {
		this.maid = maid;
	}
	public String getMapwd() {
		return mapwd;
	}
	public void setMapwd(String mapwd) {
		this.mapwd = mapwd;
	}
	public String getMaphone() {
		return maphone;
	}
	public void setMaphone(String maphone) {
		this.maphone = maphone;
	}
	public String getMaemail() {
		return maemail;
	}
	public void setMaemail(String maemail) {
		this.maemail = maemail;
	}
	public String getSysdate() {
		return sysdate;
	}
	public void setSysdate(String sysdate) {
		this.sysdate = sysdate;
	}

	

}
