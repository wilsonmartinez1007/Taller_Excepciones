import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class App  extends JFrame implements ItemListener{
    Container contenedor;
    GridLayout layout;
    FlowLayout layout2, layout3;
    JComboBox<String> combo;
    String nombre_platos[]={"","",""};
    static List<Platos> lista4 = new ArrayList<>();

    App(){
        this.contenedor = this.getContentPane();
        this.layout = new GridLayout(3,0);
        this.contenedor.setLayout(this.layout);
        
        this.layout2 = new FlowLayout();
        JPanel panel1 = new JPanel(this.layout2);

        JLabel etiqueta = new JLabel("                                    --Bienvenido al Restaurante a continuacion nuestro MENU--"                                                                          );
        panel1.add(etiqueta);

        Platos name;

        for(int i = 0; i<lista4.size(); i++){
            name = lista4.get(i);
            this.nombre_platos[i] = name.nombre;
        }
        this.combo = new JComboBox<String>(this.nombre_platos);
        this.combo.addItemListener(this);
        this.contenedor.add(panel1);


        this.layout2 = new FlowLayout();
        JPanel panel2 = new JPanel(this.layout);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);

    }


    public static void main(String[] args) throws Exception {
        Platos plato1 = new Platos("Hamburgesa", "no se la verdad", Tipo_plato.Entrada, 8000, (byte)30);
        Platos plato2 = new Platos("Limonada", "Jugo fresco con sabor a limonada", Tipo_plato.Bebida, 1500, (byte)10);
        Platos plato3 = new Platos("Postre", "tampoco se la verdad", Tipo_plato.Plato_fuerte, 8000, (byte)30);
        lista4.add(0, plato1);
        lista4.add( 1, plato2);
        lista4.add(2, plato3);

        App app = new App();
    }


   
    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(e.getStateChange());
        Platos precios;
        if(e.getStateChange()==1){
            
            if(e.getSource()==combo){
               String name_fish[] = { "Hamburgesa","Limonada","Postre"  };
               for (int j = 0; j<3; j++) {

                         if(combo.getSelectedItem() == name_fish[j]){
                    Platos name;
                    for(int i = 0; i<1; i++){
                        name = lista4.get(j);
                        JOptionPane.showMessageDialog(contenedor, name.getNombre() + " \n" + name.getDescripcion() +
                                                     "\nTipo: " + name.getTipo() + "\nValor: " + name.getCosto() + "\nTiempo preparacion: " 
                                                    +  name.getTiempo_preparacion(), "--Informacion MENU---",1);                     
                   }  
                 }
                }
                System.out.println("boton 1 es "+button1.isSelected());
                }               
            }
    }

    }
}
