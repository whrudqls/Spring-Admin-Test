package kr.co.kosmo.mvc.vo;

/*
 * 
 * lid number constraint item_semi_lid_fk references local_semi(lno) on delete cascade,
otitle varchar(20),
oprice number

 */
public class ItemVO {

	private int lid,oprice;
	private String otitle;
	
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getOprice() {
		return oprice;
	}
	public void setOprice(int oprice) {
		this.oprice = oprice;
	}
	public String getOtitle() {
		return otitle;
	}
	public void setOtitle(String otitle) {
		this.otitle = otitle;
	}
	
}
