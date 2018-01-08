package com.xzc.androiddemo.entity;

import java.io.Serializable;
import java.util.List;

/**全国省市县区 实体类**/
public class ProvinceNameEntity implements Serializable {
	
	private String result;//": 1,
	private String message;//": "",
	private List<Province> data;//": [{
	
	public String getResult() {
	
		return result;
	}
	public void setResult(String result) {
	
		this.result = result;
	}
	public String getMessage() {
	
		return message;
	}
	public void setMessage(String message) {
	
		this.message = message;
	}
	public List<Province> getData() {
	
		return data;
	}
	public void setData(List<Province> data) {
	
		this.data = data;
	}

	/**直辖市/省 实体类*/
	public static class Province implements Serializable {
		private String provinceid;//": 1,
		private String provincename;//": "北京市",
		private List<City> list;//": [{
		
		public String getProvinceid() {
		
			return provinceid;
		}
		
		public void setProvinceid(String provinceid) {
		
			this.provinceid = provinceid;
		}
		
		public String getProvincename() {
		
			return provincename;
		}
		
		public void setProvincename(String provincename) {
		
			this.provincename = provincename;
		}
		
		public List<City> getList() {
		
			return list;
		}
		
		public void setList(List<City> list) {
		
			this.list = list;
		}

		@Override
		public String toString() {

			return "Province [provinceid=" + provinceid + ", provincename=" +
				provincename + ", list=" + list + "]";
		}
		
	}
	
	/**城市 实体类*/
	public static class City implements Serializable {
		private String cityid;//": 1,
		private String cityname;//": "北京市",
		private List<District> list;//": [{
		
		public String getCityid() {
		
			return cityid;
		}
		
		public void setCityid(String cityid) {
		
			this.cityid = cityid;
		}
		
		public String getCityname() {
		
			return cityname;
		}
		
		public void setCityname(String cityname) {
		
			this.cityname = cityname;
		}
		
		public List<District> getList() {
		
			return list;
		}
		
		public void setList(List<District> list) {
		
			this.list = list;
		}

		@Override
		public String toString() {

			return "City [cityid=" + cityid + ", cityname=" + cityname +
				", list=" + list + "]";
		}
		
	}

	/**区/县 实体类*/
	public static class District implements Serializable {
		private String districtid;//": 1,
		private String districtname;//": "东城区"
		
		public String getDistrictid() {
		
			return districtid;
		}
		
		public void setDistrictid(String districtid) {
		
			this.districtid = districtid;
		}
		
		public String getDistrictname() {
		
			return districtname;
		}
		
		public void setDistrictname(String districtname) {
		
			this.districtname = districtname;
		}

		@Override
		public String toString() {

			return "District [districtid=" + districtid + ", districtname=" +
				districtname + "]";
		}
		
	}

	@Override
	public String toString() {

		return "ProvinceNameEntity [result=" + result + ", message=" + message +
			", data=" + data + "]";
	}
	
}
