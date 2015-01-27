package com.sonal.clone.deep;

public class DeepClonningExample implements Cloneable{

	private int id;
	private String userName;
	private DetailsDTO detailsDTO;
	
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
	public DetailsDTO getDetailsDTO() {
		return detailsDTO;
	}
	public void setDetailsDTO(DetailsDTO detailsDTO) {
		this.detailsDTO = detailsDTO;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		
		DeepClonningExample clonningExample = new DeepClonningExample();
		
		clonningExample.setId(id);
		clonningExample.setUserName(userName);
		DetailsDTO detailsDTO = new DetailsDTO();
		detailsDTO.setAge(this.detailsDTO.getAge());
		clonningExample.setDetailsDTO(detailsDTO);
		
		return clonningExample;
	}
	
	
	
}
