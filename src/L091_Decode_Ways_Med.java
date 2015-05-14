
import java.util.HashMap;


public class L091_Decode_Ways_Med {

    // idea: recursion, dfs
    // idea: dinamic progr, fibonacci
    HashMap<String, Character> map = new HashMap<String, Character>();
    boolean inited = false;
    
    public int numDecodings2(String s) {
        if(s==null)
            return 0;
            
        if(s.isEmpty())
            return 0;
            
        if(!inited){
            inited = true;
            for(int i=0; i < 26; i++){
                map.put(""+(i+1), (char)('A' + i));
            }
        }    
        
        
        int count = 0;
        for(int i=1; i<=2; i++){
            if(i<=s.length() && map.containsKey("" + s.charAt(0)+(i==2?s.charAt(1):""))){
                int r = numDecodings(s.substring(i));
                count+=r;
            }
        }
        
        return count;
    }
    
    
    public int numDecodings(String s) {
        
        if(s.length()==0)
            return 0;
        
        if(s.length()==1)
            return s.charAt(0)=='0'?0:1;
        
        if(s.charAt(0)=='0')
            return 0;
        
        int[] num=new int[s.length()];
        num[0]=1;
        num[1]=0;
        if(valid(s,0,1))
            num[1]+=1;
        
        if(s.charAt(1)!='0')
            num[1]+=1;
        
        if(num[1]==0)
            return 0;
        
        for(int i=2;i<s.length();i++){
            if(!valid(s,i-1,i)){
                if(s.charAt(i)=='0')
                    return 0;                
                else
                    num[i]=num[i-1];                
            }
            else{
                if(s.charAt(i)=='0'){
                    num[i]=num[i-2];
                }
                else{
                    if(!valid(s,i-2,i-1)){
                        num[i]=2*num[i-2];
                    }
                    else{
                        num[i]=num[i-2]+num[i-1];
                    }
                }
            }

        }
        return num[s.length()-1];
    }
    
    public boolean valid(String s,int i,int j){
        if(s.charAt(i)>='3' || s.charAt(i)=='0')
            return false;
        
        if(s.charAt(i)=='2' && s.charAt(j)>'6')
            return false;        
        else
           return true;         

    }
}
