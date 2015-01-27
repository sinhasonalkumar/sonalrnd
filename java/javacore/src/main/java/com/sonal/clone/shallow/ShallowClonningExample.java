package com.sonal.clone.shallow;

public class ShallowClonningExample implements Cloneable {

	private int id;
	private String userName;
	private DetailsVO detailsVO;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public DetailsVO getDetailsVO() {
		return detailsVO;
	}
	public void setDetailsVO(DetailsVO detailsVO) {
		this.detailsVO = detailsVO;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	

}
