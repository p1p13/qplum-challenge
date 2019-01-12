import java.util.*;

public class Cars {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    while(t-- != 0) {
      int n =  Integer.parseInt(sc.nextLine());
      Car cars[] = new Car[n];
      for(int i=0; i<n; i++) {
        String[] carDetails = sc.nextLine().split(" ");
        int position = Integer.parseInt(carDetails[0]);
        int speed = Integer.parseInt(carDetails[1]);
        cars[i] = new Car(position, speed);
      }
      Arrays.sort(cars);
      TreeMap<Integer, Integer> tm= new TreeMap<>();
      int ans=0;
      for(int i=n-1;i>=0;i--){
        int speed = cars[i].speed;

        //to implement binary search here
        for(int currentSpeed: tm.keySet()){
          if(currentSpeed < speed)
            ans+= tm.get(currentSpeed);
          else
            break;
        }
        if(tm.containsKey(speed)){
          tm.put(speed, tm.get(speed)+1);
        }
        else{
          tm.put(speed, 1);
        }
      }
      System.out.println(ans);
    }

  }

  static class Car implements Comparable<Car> {
    int position, speed;
    public Car (int position, int speed){
      this.position = position;
      this.speed = speed;
    }
    public int compareTo(Car car) {
      return this.position - car.position;

    }
  }
}