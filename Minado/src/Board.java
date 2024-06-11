import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

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
        System.out.println(toString());
        Scanner in = new Scanner(System.in);
        play(in);
        in.close();
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

    private void play(Scanner in){
        int i;
        int j;
        boolean t = false;
        j = in.nextInt()-1;
        in.nextLine();
        i = in.nextInt()-1;
        if (b[i][j].isBomb()){b[i][j].toggleBomb(); placeBomb();}
        int n = b[i][j].getNearBombs();
        b[i][j].firstplay();
        while(n>0){placeBomb();n--;}
        t = b[i][j].reveal();
        System.out.println(toString());
        while(!t){
            j = in.nextInt()-1;
            in.nextLine();
            i = in.nextInt()-1;
            t = b[i][j].reveal();
            System.out.println(toString());
        }
    }


    @Override
    public String toString() {
        String s = "";
        for (Node[] nodes : b) {
            s=s+"|";
            for (int i = 0; i < nodes.length-1; i++) {
                s= s+ nodes[i] + " ";
            }
            s= s + nodes[nodes.length-1] + "|\n";
        }
        return s;
    }
}
