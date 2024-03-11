import java.util.Arrays;
public class Game {
    private char p1, p2;
    //private int [][] tab = {{3,4,5},{6,7,8},{9,10,11}};
    private int [][] tab = {{1,2,1},{4,2,1},{9,2,1}};

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
    
}
