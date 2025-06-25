package electriclaDeviceController;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DeviceClass implements Device{

	private static  int dcnt;
	private String deviceName;
	private boolean isOn;
	private long startTime;
	private long totalActivetime;
	private int deviceId;
	private Date onTime;
	private Date offTime;
	private String status;
	SimpleDateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
public DeviceClass(String deviceName) {
		this.deviceName = deviceName;
		
		dcnt++;
		this.deviceId=dcnt;
		this.isOn = false;
		this.startTime = 0;
		totalActivetime = 0;
//		this.onTime ;
//		this.offTime ;
		status="off";
	}





public static int getDcnt() {
	return dcnt;
}

public String getDeviceName() {
	return deviceName;
}

public void setDeviceName(String deviceName) {
	this.deviceName = deviceName;
}

public boolean getIsOn() {
	return isOn;
}

public void setIsOn(boolean isOn) {
	this.isOn = isOn;
}

public long getStartTime() {
	return startTime;
}

public void setStartTime(long startTime) {
	this.startTime = startTime;
}

public long getTotalActivetime() {
	return totalActivetime;
}
public void setTotalActivetime(long totalActivetime) {
	this.totalActivetime = totalActivetime;
}

public int getDeviceId() {
	return deviceId;
}

public void setDeviceId(int deviceId) {
	this.deviceId = deviceId;
}

public String getOnTime() {
	return (onTime != null && onTime.getTime() !=0 )? dateformat.format(onTime):"0";
}

public void setOnTime(Date onTime) {
	this.onTime = onTime;
}

public String getOffTime() {
	return (offTime != null && offTime.getTime() !=0 )? dateformat.format(offTime):"0";
}

public void setOffTime(Date offTime) {
	this.offTime = offTime;
}

public SimpleDateFormat getDateformat() {
	return dateformat;
}

public void setDateformat(SimpleDateFormat dateformat) {
	this.dateformat = dateformat;
}

public String getStatuss() {
	return status;
}



	@Override
	public void turnOn() {
		if(!isOn)
		{
			isOn=true;
			startTime=System.currentTimeMillis();
			onTime=new Date(startTime);
			status="on";
			//totalActivetime= System.currentTimeMillis()-startTime;
			System.out.println("Device name : "+deviceName+", Id : "+deviceId+", turn on time : "+dateformat.format(onTime));
		}
		else {
			System.out.println("Device Name : "+deviceName+", id :"+deviceId+", is already on ");
		}
		
	}

	@Override
	public void turnOff() {
		if(isOn)
		{
			isOn=false;
			status="off";
			totalActivetime= (System.currentTimeMillis()-startTime)/1000;
			offTime=new Date(System.currentTimeMillis());
			//totalActivetime= 
			System.out.println("Device name : "+deviceName+" Id : "+deviceId+" turn off time : "+dateformat.format(offTime));
		}
		else {
			System.out.println("Device Name : "+deviceName+" id :"+deviceId+" is already off ");
		}		
	}

	@Override
	public void getStatus() {
//		String status;
		long act_time;
		if(isOn)
		{
			status="on";
			act_time=totalActivetime + (System.currentTimeMillis()-startTime);
		}
		else
		{
			status="off";
			act_time=totalActivetime;
		}
		
		System.out.println("\nDevice name : "+deviceName+" Id : "+deviceId +" status : "+status);
		
		if(onTime!=null)
		{
			System.out.println("\n on time : "+dateformat.format(onTime));
		}
		if(offTime!=null)
		{
			System.out.println("\n off time : "+dateformat.format(offTime));
		}
		
		System.out.println("\nTotal Active Time : "+act_time/1000 +"sec");
		
	}

//	@Override
//	public String getDeviceName() {
//		return deviceName;
//	}
	
	

}
