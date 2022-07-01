package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lotto_6603 {
	static int k;
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int [] s;
        boolean [] chk;
        
        while(true){
            String testCase=br.readLine();
            if(testCase.equals("0")) {
            	break;
            }
            String [] input=testCase.split(" ");
            k=Integer.parseInt(input[0]);
            s=new int[k];
            chk=new boolean[k];
            for(int i=0;i<k;i++){
                s[i]=Integer.parseInt(input[i+1]);
            } //초기 값 세팅

            dfs(0,0, chk, s, sb);
            sb.append("\n");        
        }
        System.out.print(sb);
    }

    public static void dfs(int depth,int start, boolean[] chk, int[]s, StringBuilder sb){
        if(depth==6){
            for(int i=0;i<k;i++){
                if(chk[i]){
                	sb.append(s[i]+" ");
                }
            }
            sb.append("\n");
        }
        for(int i=start;i<k;i++){
            chk[i]=true;
            dfs(depth+1,i+1,chk, s, sb);
            chk[i]=false;
        }
    }

}
