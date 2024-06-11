import java.util.Random;
import java.util.ArrayList;

public class Board {
    private Node[][]b;
    private final int x;
    private final int y;
    private int bombcount;

    public Board(int x, int y,int n){
        this.x =x;
        this.y=y;
        b= new b[y][x];
        bombcount = n;
        init();
    }


    private void init(){
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
            ArrayList<Node> edges = new ArrayList<>();
            if(j!=0){}

                
            }
        }
    }

    private void placeBomb(){
        Random r = new Random();
        int xr = r.nextInt(x);
        int yr =r.nextInt(y);
        while(b[yr][xr].isBomb()){
            xr = r.nextInt(x);
            yr = r.nextInt(y);
        }
        b[yr][xr].toggleBomb();
    }


}
