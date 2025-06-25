package electriclaDeviceController;

import java.util.ArrayList;
import java.util.List;

public abstract class RoomClass implements Room{
	
	private static int rmCnt;
	private int roomId;
	private String roomType;
	 List<DeviceClass> devices;
	
	
	
//	public RoomClass() {
//			roomId++; 
//		this.devices = new ArrayList<DeviceClass>();
//	}
	
	public RoomClass(String roomType) {
		//this.roomId=roomId;
		rmCnt++;
		this.roomType = roomType;
		this.devices = new ArrayList<DeviceClass>();
		this.roomId=rmCnt;
		//devices.add(new Showers("shower"));
	}
	
	
	
	
	public static int getRmCnt() {
		return rmCnt;
	}




	public static void setRmCnt(int rmCnt) {
		RoomClass.rmCnt = rmCnt;
	}




	public int getRoomId() {
		return roomId;
	}




	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}




	public String getRoomType() {
		return roomType;
	}




	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}




	public List<DeviceClass> getDevices() {
		return devices;
	}




	public void setDevices(List<DeviceClass> devices) {
		this.devices = devices;
	}




	public void addDevice(DeviceClass dev)
	{
		devices.add(dev);
		
		System.out.println(dev.getDeviceId()+" : "+dev.getDeviceName()+" added to "+roomType);
	}
	
	public void removeDevice(int devId)
	{
		DeviceClass dev=searchDevice(devId);
		if(dev != null)
		{
			devices.remove(dev);
			System.out.println(dev.getDeviceId()+" : "+dev.getDeviceName()+" removed from "+roomType);

		}
	}
	public void turnOnDevice(int devId)
	{
		DeviceClass dev=searchDevice(devId);
		if(dev != null)
		{
			dev.turnOn();
			System.out.println(dev.getDeviceId()+" : "+dev.getDeviceName()+" turn on  from "+roomType);

		}

	}
	public void turnOffDevice(int devId)
	{
		DeviceClass dev=searchDevice(devId);
		if(dev != null)
		{
			dev.turnOff();
			System.out.println(dev.getDeviceId()+" : "+dev.getDeviceName()+" turn off  from "+roomType);

		}
	}
	
	public void getStatus(int devId)
	{
		DeviceClass dev=searchDevice(devId);
		if(dev != null)
		{
			dev.getStatus();
			
		}
	}
	
	public DeviceClass  searchDevice(int devID)
	{
		for(DeviceClass d : devices)
		{
			if(d.getDeviceId()==devID)
			{
				return d;
			}
		}
		System.out.println("device not found");
		return null;
	}




	@Override
	public String toString() {
		return "RoomClass [roomId=" + roomId + ", roomType=" + roomType + ", devices=" + devices + ", getRoomId()="
				+ getRoomId() + ", getRoomType()=" + getRoomType() + ", getDevices()=" + getDevices() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	
	

}
