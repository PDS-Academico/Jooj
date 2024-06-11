public class Node {
    private Node [] edge;
    private boolean hidden;
    private boolean bomb;
    private int nearBombs;

    public Node(Node[]edge, boolean bomb){
        this.edge=edge;
        this.bomb=bomb;
        countBomb();
    }

    public boolean reveal(){
        if(isBomb()){return true;}
        if(nearBombs>0||!isHidden()){return false;}
        for (Node n : edge) {
            n.reveal();
        }
        return false;
    }

    public void toggleBomb(){
        bomb=!bomb;
        for (Node n : edge) {
            n.nearBomb(bomb);
        }
    } 

    public void nearBomb(boolean t){
        if(t){nearBombs++;}
        else{nearBombs--;}
    }

    /*private void countBomb(){
        nearBombs = 0;
        for (Node n : edge) {
            if(n.isBomb()){nearBombs++;}
        }
    }*/

    public int getNearBombs(){return nearBombs;}
    public boolean isBomb(){return bomb;}
    public boolean isHidden(){return hidden;}
}
