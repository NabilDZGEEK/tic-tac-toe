import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class button extends JButton { //button de la matrice
    int i,j;
    button(int x,int y){
       setBounds(x,y,80,80);
       Font font = new Font("Arial",Font.BOLD,35);
       setFont(font);
       addActionListener(onclick);
    }

    ActionListener onclick= new ActionListener() {//quand je clique sur une case
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            setText("X");
            matrice.mat[i][j]=cellule.x;
            matrice.lignecomplete(i,j,'x');
            matrice.cpt++;
            if(matrice.cpt<9){
                matrice.insertionordi();

            }else{
                fenetre.faireresultat(0);
            }

        }
    };
}
