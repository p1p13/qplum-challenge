import java.util.*;

public class CEO {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    while(t-- != 0) {
      int n =  Integer.parseInt(sc.nextLine());
      Employee employees[] = new Employee[n];
      for(int i=0; i<n; i++) {
        String[] employeeDetails = sc.nextLine().split(" ");
        int salary = Integer.parseInt(employeeDetails[0]);
        int subordinateSalarySum = Integer.parseInt(employeeDetails[1]);
        employees[i] = new Employee(salary, subordinateSalarySum);

      }
      ArrayList<Integer> arr = new ArrayList<>();
      HashMap<Integer, Employee> hs=new HashMap<>();
      for(int i=0;i<n;i++)
        hs.put(employees[i].salary, employees[i]);

      for(int i=0; i<n; i++){
        Employee employee = employees[i];
        HashMap<Integer, Employee> hs1 = (HashMap<Integer, Employee>)hs.clone(); 
        hs1.remove(employee.salary);
        if (possible(employee, hs1, employees) && hs1.size()==0){

          arr.add(employee.salary);
        }
      }
      Collections.sort(arr);
      for(int x:arr){
        System.out.print(x + " ");
      }
      System.out.println();

    }


  }

  public static boolean possible(Employee employee, HashMap<Integer, Employee> hs, Employee[] employees) {
    if (employee.subordinateSalarySum == 0) {
      return true;
    }

    int sum = employee.subordinateSalarySum;
    for(int i=0;i<employees.length;i++){
      int salary = employees[i].salary;
      if(hs.containsKey(salary)){
        if(salary== sum){
          hs.remove(salary);
          if(possible(employees[i], hs, employees) && hs.size()==0){
            return true;
          }
          else{
            hs.put(salary, employees[i]);
          }
        }
        else if(hs.containsKey(sum-salary)){
          Employee second = hs.get(sum-salary);
          hs.remove(salary);
          if(possible(employees[i], hs, employees)){
            hs.remove(sum-salary);
            if(possible(second, hs, employees) && hs.size()==0){
              return true;
            }
            else
              hs.put(sum-salary, second);
              hs.put(salary,employees[i]);
          }
          hs.put(salary,employees[i]);
        }
      }
    }
    return false;
  }

  static class Employee   {
    int salary, subordinateSalarySum;
    public Employee (int salary, int subordinateSalarySum){
      this.salary = salary;
      this.subordinateSalarySum = subordinateSalarySum;
    }
  }
}