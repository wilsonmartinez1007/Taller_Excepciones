import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class App  extends JFrame implements ItemListener, ActionListener{
    Container contenedor;
    GridLayout layout;
    FlowLayout layout2, layout3;
    JComboBox<String> combo;
    String nombre_platos[]={"","",""};
    static List<Platos> lista4 = new ArrayList<>();
    JTextField campo1, campo2, campo3;
    JButton button1, button2;
    int listaCarritoCompras[] = {0,0,0};
    int listaCarritoCompras2[] = {0,0,0};
    

    App(){
        contenedor = getContentPane();
        layout = new GridLayout(3,0);
        contenedor.setLayout(layout);

        layout2 = new FlowLayout();
        JPanel panel1 = new JPanel(layout2);

        JLabel etiqueta = new JLabel("                              --Bienvenido al Restaurante a continuacion nuestro MENU--                                                                     -                 ");
        panel1.add(etiqueta);

        Platos name;
        
        for(int i = 0; i<lista4.size(); i++){
            name = lista4.get(i);
            nombre_platos[i] = name.nombre;
        }
        combo = new JComboBox<String>(nombre_platos);
        combo.addItemListener(this);
        panel1.add(combo);
        contenedor.add(panel1);
        


        layout2 = new FlowLayout();
        JPanel panel2 = new JPanel(layout2);

       
        JLabel etiqueta3 = new JLabel("--                                     Puede dijitar la cantidad de platos que desea:   ----                                                                               -");
        panel2.add(etiqueta3);
        
        JLabel etiqueta2 = new JLabel(nombre_platos[0]+": ");
        panel2.add(etiqueta2);
        campo1 = new JTextField(10);
        panel2.add(campo1);
        JLabel etiqueta4 = new JLabel(nombre_platos[1]+": ");
        panel2.add(etiqueta4);
        campo2 = new JTextField(10);
        panel2.add(campo2);
        JLabel etiqueta5 = new JLabel(nombre_platos[2]+": ");
        panel2.add(etiqueta5);
        campo3 = new JTextField(10);
        panel2.add(campo3);

        button1 = new JButton("Presiona para enviar pedido.");
        button1.addActionListener(this);
        panel2.add(button1);
        
        contenedor.add(panel2);

        layout3 = new FlowLayout();
        JPanel panel3 = new JPanel(layout2);

        button2 = new JButton("Presiona para mostrar factura.");
        button2.addActionListener(this);
        panel3.add(button2);

        contenedor.add(panel3);

        
                 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

    }


    public static void main(String[] args) throws Exception {
        Platos plato1 = new Platos("Hamburgesa", "Jugosa Hamburgesa de caren de res a la parrilla con queso, lechuga fresa y tomate", Tipo_plato.Plato_fuerte, 20000, (byte)30);
        Platos plato2 = new Platos("Limonada", "Jugo fresco con sabor a limonada", Tipo_plato.Bebida, 3000, (byte)10);
        Platos plato3 = new Platos("Ensalada Griega", "Refrescante ensalada compuesta por pepino, tomate,cebolla roja y aceitunas", Tipo_plato.Entrada, 8000, (byte)30);
        lista4.add(0, plato1);
        lista4.add( 1, plato2);
        lista4.add(2, plato3);

        App app = new App();
    }


   
    @Override
    public void itemStateChanged(ItemEvent e) {
         if(e.getStateChange()==1){
            
            if(e.getSource()==combo){
               String name_fish[] = { "Hamburgesa","Limonada","Ensalada Griega"  };
               for (int j = 0; j<name_fish.length; j++) {

                
            
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
                }               
            }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button1){
            Platos precios;
            int valor1, valor2, valor3 = 0;
            try{
                System.out.println("Bloque try ejecutado.");
                
                if (campo1.getText().isEmpty()){
                    throw new Excepciones("No se han pedidio hamburgesas.");
                }
                valor1 = Integer.parseInt(campo1.getText());
                precios = lista4.get(0);
                listaCarritoCompras[0] = valor1;
                listaCarritoCompras2[0] = valor1 * precios.costo;
            }catch(Excepciones ex){
                String mensaje = ex.getMessage();
                System.out.println("Excepción: " + mensaje);
                   
                }try{
                if(campo2.getText().isEmpty()){
                throw new Excepciones("No se han pedido limonadas.");
                        }
                valor2 = Integer.parseInt(campo2.getText());
                precios = lista4.get(1);
                listaCarritoCompras[1] = valor2;
                listaCarritoCompras2[1] = valor2 * precios.costo;     
                }catch(Excepciones ex){
                    String mensaje = ex.getMessage();
                    JOptionPane.showMessageDialog(contenedor, ("Excepción: " + mensaje), "ERROR", 1);return;
                }
            try{
                if (campo3.getText().isEmpty()){
                    throw new Excepciones("No se han pedidio postre.");
                }   
                valor3 = Integer.parseInt(campo3.getText());
                precios = lista4.get(2);
                listaCarritoCompras[2] = valor3;
                listaCarritoCompras2[2] = valor3 * precios.costo;
                }catch(Excepciones ex){
                
                String mensaje = ex.getMessage();
                System.out.println("Excepción: " + mensaje);
                                }
        }if(e.getSource() == button2){
            try{
            if(listaCarritoCompras[1] == 0){
                throw new Excepciones("que enfermo come sin bebida xD.");}
            }catch(Excepciones ex){
            String mensaje = ex.getMessage();
            JOptionPane.showMessageDialog(contenedor, ("Excepción: " + mensaje), "ERROR", 1);return;}
            int suma = 0;
            for (int suma2 : listaCarritoCompras2) {suma += suma2;}
            try{
            if(suma > 200000){
                throw new Excepciones("No es normal gastar tanto en un almuerzo, quizá se equivocó.");}
            }catch(Excepciones ex){
            String mensaje = ex.getMessage();
            JOptionPane.showMessageDialog(contenedor, ("Excepción: " + mensaje), "ERROR", 1);return;}
            try{
                for (int cantidad : listaCarritoCompras) {
                    
                    if(cantidad > 5){
                        throw new Excepciones("Solo es permitido menos de 5 unidades de un mismo plato");
                    }       
                }System.out.println("bien");
            }catch(Excepciones ex){
                String mensaje = ex.getMessage();
                JOptionPane.showMessageDialog(contenedor, ("Excepción: " + mensaje), "ERROR", 1);return;}
            
            for (int i = 0; i < listaCarritoCompras.length; i++) {
                Platos pedidos;
                pedidos = lista4.get(i);
                if(listaCarritoCompras[i] != 0){
                    String nombre = "Nombre: "+ pedidos.nombre;
                    String descripcion = "Descripcion pedido: "+ pedidos.descripcion;
                    Tipo_plato tipo = pedidos.tipo;
                    int costo = listaCarritoCompras2[i];
                    byte tiempo = pedidos.tiempo_preparacion;
                    JOptionPane.showMessageDialog(contenedor, nombre+ "\n" + descripcion + "\nTipo: "+ tipo + "\ncosto: "+costo +
                                                "\nTiempo- preparacion: " + tiempo + " minutos", "--FACTURA--",1);
                }
            }
            
        }
    }
}
