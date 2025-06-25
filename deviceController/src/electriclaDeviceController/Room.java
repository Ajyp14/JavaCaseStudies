package electriclaDeviceController;

public interface Room {

	void addDevice(DeviceClass device);
	void removeDevice(int deviceId);
	void turnOffDevice(int deviceId);
	void turnOnDevice(int deviceId);
	void getStatus(int devId);
	//String getRoomType();
	
}
