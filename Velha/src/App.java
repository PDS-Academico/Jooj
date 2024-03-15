import javax.naming.spi.DirStateFactory.Result;

public class App {
    public static void main(String[] args) throws Exception {
        Game g = new Game('X','O');
        System.out.println(g);
        switch(g.match()){
            case P1W: System.out.println("P1 Ganhou"); break;
            case P2W: System.out.println("P2 Ganhou"); break;
            case DRAW: System.out.println("Ninguém Ganhou");break;
        }
    }
}
