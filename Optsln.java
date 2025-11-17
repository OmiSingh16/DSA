public class Optsln {
  public static int Optimalmidsoln(int arr[]){ 
    int ans = Integer.MAX_VALUE;
    int n=arr.length;  
    boolean found = false;


    for(int j=1; j<n-1; j++){
      int leftmin = Integer.MAX_VALUE;
      int rightmin = Integer.MAX_VALUE;

      for(int i=0 ; i<j; i++){
        if(arr[i]<arr[j]){
          leftmin = Math.min(leftmin ,arr[i]);
        }
      }

      for(int k =j+1; k<n; k++){
        if(arr[k]<arr[j]){
          rightmin = Math.min(rightmin,arr[k]);
        }
      }

      if(leftmin!=Integer.MAX_VALUE && rightmin != Integer.MAX_VALUE){
        ans = Math.min(ans , leftmin + arr[j]+rightmin);
        found = true;
      }
    }
    return found?ans:-1;
  }

  public static void main(String[] args) {
    int arr[]={3,4,5,1,2,3,1};
    int result = Optimalmidsoln(arr);
    System.out.println(result);
  }
}
