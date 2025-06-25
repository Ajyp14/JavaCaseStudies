package electriclaDeviceController;

public class Television extends DeviceClass{

	static int tId=1;
	
	public Television(String deviceName) {
		super(deviceName);
		tId++;
	}

}
