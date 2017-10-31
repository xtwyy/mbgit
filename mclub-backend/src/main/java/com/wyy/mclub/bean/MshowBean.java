package com.wyy.mclub.bean;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class MshowBean {
	 	public String userid;
	    public String startday;
	    public String endday;
	    public String ovulationday;
	    public Map dailyRecords;
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}

		
		public String getStartday() {
			return startday;
		}
		public void setStartday(String startday) {
			this.startday = startday;
		}
		public String getEndday() {
			return endday;
		}
		public void setEndday(String endday) {
			this.endday = endday;
		}
		public String getOvulationday() {
			return ovulationday;
		}
		public void setOvulationday(String ovulationday) {
			this.ovulationday = ovulationday;
		}

		public Map getDailyRecords() {
			return dailyRecords;
		}
		public void setDailyRecords(Map dailyRecords) {
			this.dailyRecords = dailyRecords;
		}

		
		
	
}

