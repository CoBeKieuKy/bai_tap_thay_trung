package garage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManageCar {
	
	//Tinh tong gia tri tien cua list xe da cho
	public static double getSumOfPrice(List<Car> carList) {
		return carList.stream().map(Car::getPrice).collect(
				Collectors.summingDouble(Double::doubleValue));
	}
	
	//Dua ra Map tu list cac xe theo dieu kien toc do cua no tren nguong minSpeed
	public static Map<String, Car> getListOfCarWithSpeedOver(List<Car> carList, double minSpeed) {
	    Map<String, Car> map = carList.stream().filter(car-> car.getSpeed() >= minSpeed)
	      .collect(Collectors.toMap(Car::getModelID, car -> car));
	    return map;
	}
	
	//Dem so luong xe dua vao gia cua no tren nguong minPrice
	public static int countCar(List<Car> carList, double minPrice) {
		return (int) carList.stream().filter(car -> car.getPrice() >= minPrice).count();
	}
	
	public static Car findCar(List<Car> carList, String modelID) {
		return carList.stream().filter(car -> modelID.equals(car.getModelID())).findFirst().orElse(null);
	}
	
	public static void main(String[] args) {
		Car car1 = new Car("1a", 50, 50);
		Car car2 = new Car("1b", 100, 100);
		Car car3 = new Car("1c", 200, 200);
		int minSpeed = 100;
		int minPrice = 150;
		String findModelID = "1a";
		
		List<Car> garage =new ArrayList<>();
		Map<String, Car> map = new HashMap<>();;
		garage.add(car1);
		garage.add(car2);
		garage.add(car3);
		
		
		
		System.out.println("So luong xe co gia tren 150 la: "+countCar(garage,minPrice));
		System.out.println("Gia tri cua toan bo list xe la: "+getSumOfPrice(garage));
		System.out.println();
		
		Car temp= findCar(garage,findModelID);
		System.out.println("###Thong tin ve xe co modelID 1a###");
		System.out.println("ModelID: "+temp.getModelID());
		System.out.println("Speed: "+temp.getSpeed());
		System.out.println("Price: "+temp.getPrice());
		System.out.println();
		
		map = getListOfCarWithSpeedOver(garage,minSpeed);
		System.out.println("Danh sach cac model xe co toc do tren 100 la: "+map.keySet().toString());
	}
}
