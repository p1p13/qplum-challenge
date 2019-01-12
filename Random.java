//incomplete

class Random {
  int[] random = new int[1000007];
  int size=0;

  public int parent(int x){
    return (x-1) / 2;
  }

  public int leftChild(int x){
    return (2*x);
  }
  public int rightChild(int x){
    return (2*x + 1);
  }

  public insert(int x){
    random[size++] = x;
    int child = size-1;
    while(random[parent(child)] < random[child]){
      int temp = random[parent(child)];
      random[parent(child)] = temp;
      random[child] = temp;
      child = parent(child);
    }
  }

  public random() {
    int time = System.currentTimeMillis();
    return random[time%size]; 
  }

  public search() {
    
  }

  public delete(int x){

  }

}