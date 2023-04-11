package kr.co.kosmo.mvc.vo;
/*
ADLOGNUM	NUMBER(10,0)
ADLOGID	VARCHAR2(100 BYTE)
ADLOGIP	VARCHAR2(80 BYTE)
ADLOGAGENT	VARCHAR2(100 BYTE)
ADLOGSTATUS	VARCHAR2(100 BYTE)
ADLOGTIME	DATE
 */
public class MyLoginLoggerDTO {
	private int adlognum;
	private String adlogid;
	private String adlogip,adlogagent,adlogstatus,adlogtime,adlogeetime;
	
	public int getAdlognum() {
		return adlognum;
	}
	public void setAdlognum(int adlognum) {
		this.adlognum = adlognum;
	}
	public String getAdlogid() {
		return adlogid;
	}
	public void setAdlogid(String adlogid) {
		this.adlogid = adlogid;
	}
	public String getAdlogip() {
		return adlogip;
	}
	public void setAdlogip(String adlogip) {
		this.adlogip = adlogip;
	}
	public String getAdlogagent() {
		return adlogagent;
	}
	public void setAdlogagent(String adlogagent) {
		this.adlogagent = adlogagent;
	}
	public String getAdlogstatus() {
		return adlogstatus;
	}
	public void setAdlogstatus(String adlogstatus) {
		this.adlogstatus = adlogstatus;
	}
	public String getAdlogtime() {
		return adlogtime;
	}
	public void setAdlogtime(String adlogtime) {
		this.adlogtime = adlogtime;
	}
	public String getAdlogeetime() {
		return adlogeetime;
	}
	public void setAdlogeetime(String adlogeetime) {
		this.adlogeetime = adlogeetime;
	}
	

	

}
