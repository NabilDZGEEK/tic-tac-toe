import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panel extends JPanel {
    static int i,j;
    static  button[][]mat=new button[3][3];
    static JLabel l;
    static boolean continu;
      panel(){//panel du match
          int x,y;
          continu=false;
          setBackground(Color.orange);
          setLayout(null);

          JLabel l=new JLabel();//titre du jeu
          l.setText("TIC TAC TAO");
          l.setBounds(210,45,250,25);
          Font font = new Font("Arial",Font.BOLD,25);
          l.setFont(font);
           add(l);
          y=15; x=100;
          for(i=0;i<3;i++){ //affichage matrice
              for (j=0;j<3;j++){
                  mat[i][j]=new button(x+80*(j+1),y+80*(i+1));
                  mat[i][j].i=i; mat[i][j].j=j;
                  add(mat[i][j]);
              }
          }


      }
      panel(int x){ //panel du resultat
          setLayout(null);
          l=new JLabel();
          setBackground(Color.green);
          l.setBounds(150,150,400,25);
          Font font = new Font("Arial",Font.BOLD,30);
          l.setFont(font);
          add(l);
          setVisible(false);
          if(x==0){
              l.setText("MATCH NULL");
          }
          JButton b=new JButton();  //button rejouer
          b.setBounds(200,200,100,30);
          b.setText("REJOUER");
          b.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent actionEvent) {
                  fenetre f=new fenetre("ma nvl fenetre");
                  matrice.initialiser();
              }
          });
          add(b);
      }
}
