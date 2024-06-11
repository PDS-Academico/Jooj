public class Node {
    private Node [] edge;
    private boolean hidden;
    private boolean bomb;
    private int nearBombs;

    public Node(){
        hidden = true;
        bomb = false;
        nearBombs = 0;
    }    
    
    public int getNearBombs(){return nearBombs;}
    public boolean isBomb(){return bomb;}
    public boolean isHidden(){return hidden;}
    public void forceReveal(){hidden = false;}

    public boolean reveal(){
        if(isBomb()){hidden = false; return true;}
        if(nearBombs>0||!isHidden()){hidden = false; return false;}
        hidden = false;
        for (Node n : edge) {
            n.reveal();
        }
        return false;
    }

    public void firstplay(){
        for (Node n : edge) {
            if(n.isBomb()){n.toggleBomb();}
        }
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

    public void setEdges(Node[] e){
        this.edge = e;
    }

    /*private void countBomb(){
        nearBombs = 0;
        for (Node n : edge) {
            if(n.isBomb()){nearBombs++;}
        }
    }*/

    @Override
    public String toString() {
        if(isHidden()){return "+";}
        if (isBomb()){return "*";}
        if(nearBombs==0){return " ";}
        return ""+nearBombs;
    }


}
