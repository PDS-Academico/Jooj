import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private Node[][]b;
    private final int x;
    private final int y;
    private int bombcount;

    public Board(int x, int y,int n){
        this.x =x;
        this.y=y;
        b= new Node[y][x];
        bombcount = n;
        init();
    }

    public Board(int x,int n){
        this.x =x;
        this.y=x;
        b= new Node[y][x];
        bombcount = n;
        init();
    }


    private void init(){
        
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                b[i][j] = new Node();
            }
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                ArrayList<Node> edges = new ArrayList<>();
                if(i!=0){
                    if(j!=0){edges.add(b[i-1][j-1]);}
                    edges.add(b[i-1][j]);
                    if(j!=x-1){edges.add(b[i-1][j+1]);}
                }
                if(j!=0){edges.add(b[i][j-1]);}
                if(j!=x-1){edges.add(b[i][j+1]);}
                if(i!=y-1){
                    if(j!=0){edges.add(b[i+1][j-1]);}
                    edges.add(b[i+1][j]);
                    if(j!=x-1){edges.add(b[i+1][j+1]);}
                }   
                b[i][j].setEdges(edges.toArray(new Node[0]));
            }
        }
        for (int i = 0; i < bombcount; i++) {
            placeBomb();
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

    @Override
    public String toString() {
        String s = "";
        String aux = " ";
        for (int i = 0; i < b[0].length; i++) {
            aux=aux+"- ";
        }
        s=s+aux+"\n";
        for (Node[] nodes : b) {
            s=s+"|";
            for (Node node : nodes) {
                s= s+ node + " ";
            }
            s= s + "|\n";
        }
        return s+aux;
    }
}
