package com.netpace.jtc.model;

import java.io.Serializable;

public class Version implements Serializable {

	private static final long serialVersionUID = 1L;

	private String versionName;
	
	private String dateCreated;
	
	private boolean showedCategoryTip = false;
	
	private boolean showedStoryDetailTip = false;

	public Version(String versionName, String dateCreated) {
		super();
		this.versionName = versionName;
		this.dateCreated = dateCreated;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isShowedCategoryTip() {
		return showedCategoryTip;
	}

	public void setShowedCategoryTip(boolean showedCategoryTip) {
		this.showedCategoryTip = showedCategoryTip;
	}

	public boolean isShowedStoryDetailTip() {
		return showedStoryDetailTip;
	}

	public void setShowedStoryDetailTip(boolean showedStoryDetailTip) {
		this.showedStoryDetailTip = showedStoryDetailTip;
	}
}
