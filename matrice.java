import javax.swing.*;
public class matrice {
    static cellule[][] mat;
    static int cpt=1; //compteur de coups
    static int i,j;
    static boolean insere=false;    //si l'ordinateur a jouer son tour
    matrice(){
        mat=new cellule[3][3];

    }
    static void initialiser(){ //initialisation de la matrice
        for(int k=0;k<3;k++) {
            for (int m = 0; m < 3; m++) {
                mat[k][m]=null;
            }
        }
        cpt=1;//initialisation du compteur
    }
     static void couper(boolean a){//completer ma ligne si a=0 sinon couper la ligne de l'adversaire
        cellule x;
        if(a){
            x=cellule.x;
        }else{
            x=cellule.o;
        }
         insere=false; int cptligne; int ind; //cpt ligne ==> nombre d'occurence de x ou o|ind ==>indicide case vide
         for(int k=0;k<3;k++){ //verfication horizontale
             cptligne=0; ind=-1;
             for(int m=0;m<3;m++){
                 if(mat[k][m]==x){
                     cptligne++;
                 }
                 if(mat[k][m]==null){
                     ind=m;
                 }
             }
             if((cptligne==2)&&(ind!=-1)){
                 insere=true; //je peux inserer mon élément
                 i=k; j=ind;    //préparation de i et j
             }
         }

         if(insere==false) { // verification verticale
             for (int m = 0; m < 3; m++) {
                 cptligne = 0; ind=-1;
                 for (int k = 0; k < 3; k++) {
                     if (mat[k][m] == x) {
                         cptligne++;
                     }
                     if (mat[k][m] == null) {
                         ind = k;
                     }
                 }
                 if ((cptligne == 2)&&(ind!=-1)) {
                     insere = true;
                     i=ind; j=m;
                 }
             }
         }
         ind=-1;
         if(insere==false){//sinon verification diagonale
             cptligne=0; ind=-1;
             for(int k=0;k<3;k++){//diagonale pricipale
                 if(mat[k][k]==x){
                     cptligne++;
                 }
                 if (mat[k][k] == null) {
                     ind = k;
                 }
             }
             if((cptligne==2)&&(ind!=-1)){
                 insere = true;
                 i=ind; j=ind;
             }else{
                 cptligne=0;ind=-1;//diagonale secondaire
                 for(int k=0;k<3;k++){
                     if(mat[2-k][k]==x){
                         cptligne++;
                     }
                     if (mat[2-k][k] == null) {
                         ind = k;
                     }
                 }
                 if((cptligne==2)&&(ind!=-1)){
                     insere = true;
                     i=2-ind;j=ind;
                 }
             }
         }
         if(insere==true){
             mat[i][j]=cellule.o;   //insersion dans la matrice
             panel.mat[i][j].setText("O");//insersion dans la matrice graphique
         }
    }

     static void ajouter(){
        if (insere==false){
          do {
              i = (int) (Math.random() * 3);
              j = (int) (Math.random() * 3);
          }while (mat[i][j]!=null);
          mat[i][j]=cellule.o;
          panel.mat[i][j].setText("O");
        }
     }
     static void insertionordi(){
        couper(false);
        if(insere==false){
            couper(true);
        }

        ajouter();

         matrice.lignecomplete(i,j,'o');
        cpt++;
    }

    static void lignecomplete(int i,int j,char c){  //verification des ligne si quelleq'un a gagné

        cellule ce=cellule.o;
        if(c=='x'){
            ce=cellule.x;
        }
        int k;
        for(k=0;k<3;k++){//iteration horizontale
            if(mat[i][k]!=ce){
                break;
            }
        }
        if(k!=3){//absense lignement horizontale alors iteration verticale
            for(k=0;k<3;k++){
                if(mat[k][j]!=ce){
                    break;
                }
            }


        }
        if(k!=3){//si ni horizontale ni verticale alors iteration diagonale
            if(i==1&&j==1){  //iteration diagonal de la case millieu
                for(k=0;k<3;k++){
                    if(mat[k][k]!=ce){//iteration diagonale principale
                        break;
                    }
                }
                if(k!=3){
                    for(k=0;k<3;k++){
                        if(mat[k][2-k]!=ce){//iteration diagonale non principale
                            break;
                        }
                    }
                }
            }
            if(((j==0)&&(i==0))||((j==2)&&(i==2))){//iteration diagonale principale
                for(k=0;k<3;k++){
                    if(mat[k][k]!=ce){
                        break;
                    }
                }
            }
            if(((j==2)&&(i==0))||((j==0)&&(i==2))){//iteration diagonale non principale
                for(k=0;k<3;k++){
                    if(mat[k][2-k]!=ce){
                        break;
                    }
                }
            }
        }
        if(k==3){  // ya une ligne complete
            if(ce==cellule.o){
                System.out.println("vous avez perdu");
                fenetre.faireresultat(-1);

            }else{
                System.out.println("vous avez gagné");
                fenetre.faireresultat(1);
            }
        }
    }

}
