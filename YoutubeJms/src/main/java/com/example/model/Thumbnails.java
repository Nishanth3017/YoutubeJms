package com.example.model;

public class Thumbnails{
    public Default defalt;
    public Default getDefalt() {
		return defalt;
	}
	public void setDefalt(Default defalt) {
		this.defalt = defalt;
	}
	public Medium getMedium() {
		return medium;
	}
	public void setMedium(Medium medium) {
		this.medium = medium;
	}
	public High getHigh() {
		return high;
	}
	public void setHigh(High high) {
		this.high = high;
	}
	public Medium medium;
    public High high;
}
