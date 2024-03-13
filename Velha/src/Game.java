import java.util.Arrays;
import java.util.Scanner;
public class Game {
    private char p1, p2;
    private int [][] tab = {{3,4,5},{6,7,8},{9,10,11}};
    private int p =1;
    //private int [][] tab = {{1,2,1},{4,2,1},{9,2,1}};

    public Game(char p1,char p2){
        this.p1 = p1;
        this.p2 = p2;
        /*for (int [] n : tab) {
            System.out.println(Arrays.toString(n));
        }*/
    }

    public String toString(){
        String s="";
        for (int y =0; y<3;y++){
            s= s+ ' '+ xo(tab[y][0])+' ';
            for (int x = 1; x<3;x++){
             s=s + "| "+ xo(tab[y][x])+ ' ';
            }
            if(y<2){s=s+"\n-----------\n";}
        }
        return s;
    }

    public char xo (int n){
        switch (n) {
            case 1:
                return p1;
        
            case 2:return p2;
            default:
                return ' ';
        }
    }
    
    public boolean winCond(){
        for (int n=0;n<3;n++){
            if(tab[0][n]==tab[1][n]&&tab[1][n]==tab[2][n]){return true;}
            if(tab[n][0]==tab[n][1]&&tab[n][1]==tab[n][2]){return true;}
        }
        if(tab[0][0]==tab[1][1]&&tab[1][1]==tab[2][2]){return true;}
        if(tab[0][2]==tab[1][1]&&tab[1][1]==tab[2][0]){return true;}
        return false; 
    }

    public Result match(){
        Scanner in = new Scanner(System.in);
        int c=0;
        while(true){
            boolean check = false;
            while (!check){
                switch (in.nextLine().toLowerCase()){
                    case "a1","1a": 
                        if (tab[0][0]<3){break;}
                        tab[0][0]=p; check=true; break;
                    case "a2","2a": 
                        if (tab[0][1]<3){break;}
                        tab[0][1]=p; check=true; break;
                    case "a3","3a": 
                        if (tab[0][2]<3){break;}
                        tab[0][2]=p; check=true; break;
                    case "b1","1b": 
                        if (tab[0][0]<3){break;}
                        tab[1][0]=p; check=true; break;
                    case "b2","2b": 
                        if (tab[0][1]<3){break;}
                        tab[1][1]=p; check=true; break;
                    case "b3","3b": 
                        if (tab[1][2]<3){break;}
                        tab[1][2]=p; check=true; break;
                    case "c1","1c": 
                        if (tab[2][0]<3){break;}
                        tab[2][0]=p; check=true; break;
                    case "c2","2c": 
                        if (tab[2][1]<3){break;}
                        tab[2][1]=p; check=true; break;
                    case "c3","3c": 
                        if (tab[2][2]<3){break;}
                        tab[2][2]=p; check=true; break;
                }
            
            }
            toString();
            if (winCond()){
                in.close();
                if (p==1) {return Result.P1W;}
                else {return Result.P2W;}
            }
            c++;
            if (c==9){in.close(); return Result.DRAW;}
            if (p==1){p=2;} else{p=1;}
        }
    }
}
