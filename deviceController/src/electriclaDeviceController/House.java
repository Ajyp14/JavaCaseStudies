package electriclaDeviceController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class House {

	List<RoomClass> rooms =new ArrayList<RoomClass>();;
	Scanner sc = new Scanner(System.in);
	
	public House() {
		this.rooms = new ArrayList<RoomClass>();
	}
	
	public void openHouse()
	{
		
		while(true)
		{
			try {

			System.out.println("\nHouse Application ");
			System.out.println("1.Add room");
			System.out.println("2.Add Device to room");
			System.out.println("3.Turn on device");
			System.out.println("4.Turn of device");
			System.out.println("5.Check Room And device status");
			System.out.println("6.remove Room");
			System.out.println("7.remove Device to room");
			System.out.println("8.Show house status ");
			System.out.println("9.exit");
			System.out.print("\nEnter your choice : ");
			int choice = sc.nextInt();
			switch(choice)
			{
			   case 1:
				   		addRoom();
				   		break;
			   case 2:
				   		addDevice();
				   		break;
			   case 3:
				    turnOndevice();
			   		break;
			   case 4:
				   turnOffdevice();
				   break;
			   case 5:
				    roomDeviceStatus();
			   		break;
			   case 6:
				    removeRoom();
			   		break;
			   case 7:
				    removeDevice();
			   		break;
			   case 8:
				   houseStatus();
			   		break;
			   case 9:
				    return;
			   default:
				   System.out.println("Invalid choice ");
				  
			}
			
		}
		catch(Exception e)
		{
			sc.nextLine();
			System.out.println("please enter valid number");
		}
			
		}
	}

	
	private void addRoom() {
	
	while(true){
			 try{
			System.out.println("select room Type ");
			System.out.println("1.Kitchen");
			System.out.println("2.Living Area");
			System.out.println("3.Dinning Area");
			System.out.println("4.Bedroom");
			System.out.println("5.Washroom");
			System.out.println("6.Corridors");
			System.out.println("7.back");
			System.out.print("\nEnter your choice : ");
			int choice= sc.nextInt();
			sc.nextLine();
			switch(choice)
			{
			  case 1:
				  rooms.add(new Kitchen("Kitchen"));
				  break;
			  case 2:
				  rooms.add(new LivingArea("LivingArea"));
				  break;
			  case 3:
				  rooms.add(new DinningArea("Dinning Area"));
				  break;
			  case 4:
				  rooms.add(new Bedroom("Bedroom"));
				  break;
			  case 5:
				  rooms.add(new Washroom("Washroom"));
				  break;
			  case 6:
				  rooms.add(new Corridors("Corridor"));
				  break;
			  case 7 : 
				  return;
			  default:
				  System.out.println("Invalid choice");
			}
			if(choice!=7)
				System.out.println("Room added successfully !!!!\n");
}
		 catch (Exception e) {
			sc.nextLine();
			System.out.println("Invalid choice Please enter valid integer number\n");
			
		}
	}	
	
	}
	
	private void addDevice() {
		RoomClass r=searchRoom();
		
		if(r!=null && !rooms.isEmpty())
		{
			while(true) {
				 try{
				System.out.println("select Device to add in : "+r.getRoomType());
				System.out.println("1.Light");
				System.out.println("2.Shower");
				System.out.println("3.television");
				System.out.println("4.Air Conditioner");
				System.out.println("5.back");
				System.out.print("\nEnter your choice : ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch(choice)
				{
				case 1:
					r.devices.add(new Light("Light"));
					break;
				case 2:
					r.devices.add(new Showers("Shower"));
					break;
				case 3:
					r.devices.add(new Television("television"));
					break;
				case 4:
					r.devices.add(new AirConditioners("Air Conditioner"));
					break;
				case 5:
					return;
				default:
					System.out.println("Invalid choice");
				}
				if(choice!=7)
					System.out.println("Device added successfully !!!!\n");
				
				}
			catch (Exception e) {
				sc.nextLine();
				System.out.println("Invalid choice Please enter valid integer number");
				
			}
			}
		}
		else {
			System.out.println("No rooms in House");
		}
		
	}
	
	private void turnOndevice() {
		
		RoomClass r=searchRoom();
		
		if(r.devices.isEmpty())
		{
			System.out.println("Room have not any device yet");
		}
		else if(r!=null)
		{
			System.out.print("Enter device Id to turn On : ");
			int devId=sc.nextInt();
			r.turnOnDevice(devId);
		}
		
		
	}
	
	private void turnOffdevice() {
		
         RoomClass r=searchRoom();
         if(r.devices.isEmpty())
 		{
 			System.out.println("Room have not any device yet");
 		}
         else if(r!=null)
		{
			System.out.println("Enter device Id to turn off : ");
			int devId=sc.nextInt();
			r.turnOffDevice(devId);
		}
		
	}
	
	private void houseStatus() {
		
		System.out.printf("| %-10s | %-15s | %-10s | %-15s | %-15s | %-20s | %-20s | %-25s |\n","Room Id","Room Name","DeviceId","Device Name","Device status","Device OnTime","Device OffTime","Device Total Active Time");
		System.out.print("|---------------------------------------------------------------------------------------------------------------------------------------------------------|\n");
		for(RoomClass r : rooms)
		{
			int cnt=0;
			System.out.printf("| %-10s | %-15s |",r.getRoomId(),r.getRoomType());
			for(DeviceClass d : r.devices)
			{
				if(cnt==0)
				{
				System.out.printf(" %-10d | %-15s | %-15s | %-20s | %-20s | %-25d sec |\n",d.getDeviceId(),d.getDeviceName(),d.getStatuss(),d.getOnTime(),d.getOffTime(),d.getTotalActivetime());
				 cnt++;
				}
				else {
					System.out.printf("| %-10s | %-15s | %-10d | %-15s | %-15s | %-20s | %-20s | %-25d |\n"," "," ",d.getDeviceId(),d.getDeviceName(),d.getStatuss(),d.getOnTime(),d.getOffTime(),d.getTotalActivetime());
				}
			}	
			if(cnt==0)
			{
				System.out.println();
			}
			 
		}		
		
	}

	private void removeDevice() {
		RoomClass r=searchRoom();
		
		if(r!=null)
		{
			System.out.println("Enter device Id to Remove ");
			int devId=sc.nextInt();
			r.removeDevice(devId);
		}
		
	}

	private void removeRoom() {
		RoomClass r=searchRoom();
		
		if(r!=null)
		{
			rooms.remove(r);
			System.out.println(r.getRoomType()+" Removed successfully ");
		}
		
	}

	private void roomDeviceStatus() {
		
		RoomClass r=searchRoom();
		
		if(r!=null)
		{
			for(DeviceClass d:r.devices)
			{
				System.out.println("----------------------------------------------------------------");
				r.getStatus(d.getDeviceId());
			}
			System.out.println("----------------------------------------------------------------");

		}
		else
		{
			System.out.println("no room available");
		}
		
}

public RoomClass searchRoom()
	{
			 
			System.out.print("Enter room Id : ");
			int rid=sc.nextInt();
			
			for(RoomClass r : rooms)
			{
				if(r.getRoomId()==rid)
					return r;
			}
			
			return null;
			
		}


public void display() {
	
	System.out.printf("| %-10s | %-15s | %-10s | %-15s | %-10s | %-10s | %-10s | %-25s |\n","Room Id","Room Name","DeviceId","Device Name","Device status","Device OnTime","Device OffTime","Device Total Active Time");
	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------\n");
	for(RoomClass r : rooms)
	{
		System.out.printf("| %-10s | %-15s |",r.getRoomId(),r.getRoomType());
		for(DeviceClass d : r.devices)
		{
			System.out.printf(" %-10d | %-15s | %-10s | %-10d | %-10d | %-25d |",d.getDeviceId(),d.getDeviceName(),d.getStatuss(),d.getOnTime(),d.getOffTime(),d.getTotalActivetime());
		}
		  
	}
	
}
	
	
	}


	


