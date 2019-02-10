import javax.swing.*;

public class fenetre extends JFrame {
    static panel p,result;//panel principale et panel resultat
    fenetre(String s){
        setTitle(s);
        setBounds(300,200,600,450);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        p=new panel();
        add(p);
        setVisible(true);
        result=new panel(0);
        add(result);
    }

    static void faireresultat(int x){
        if(x==-1){
            panel.l.setText("VOUS AVEZ PERDU");
        }
        if(x==1){
            panel.l.setText("VOUS AVEZ GAGNÉ");
        }
        p.setVisible(false);
        result.setVisible(true);
    }
}
