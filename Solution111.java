class Solution111 {
    public String getSmallestString(int n, int k) {
        int arr[]= new int[n];
 
        for( int i=0;i<n;i++)
        {
             arr[i]=1;
        }
 
        k=k-n;
 
        int i=n-1;
        while(k>0)
        {
            if(k>25)
            {
                 arr[i]=26;
                 k=k-25;
                 i--;
            }
            else
            {
                  // assume k=18
                  arr[i]=k+1;
                  k=0;
                  break;
            }
        }
 
        StringBuilder ans= new StringBuilder();
 
        for(  i=0;i<n;i++)
        {
             ans.append( (char)(arr[i]+96));
        }
 
         return ans.toString();
    }
}


/* 
  class Solution {
    public int maxProfit(int[] prices) {
        
        int profit=0;

        for( int i=1;i<prices.length;i++)
        {
             if( prices[i]> prices[i-1])
             {
                 profit+= (prices[i]-prices[i-1]);
             }
        }
        return profit;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        
         int n =prices.length;
         int mi=prices[0];
         int ans=0;

         for( int i=1;i<n;i++)
         {
              int profit = prices[i]- mi;

              if( profit > ans )
              {
                 ans= profit;
              }

              if( prices[i]< mi)
              {
                mi= prices[i];
              }
         }
         return ans;
    }
}

 */