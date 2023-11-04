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

        JLabel etiqueta3 = new JLabel("--                                      Puede dijitar la cantidad de platos que desea:                                                                  ---");
        panel2.add(etiqueta3);

        JLabel etiqueta2 = new JLabel(this.nombre_platos[0]+": ");
        panel2.add(etiqueta2);
        this.campo1 = new JTextField(10);
        panel2.add(this.campo1);
        JLabel etiqueta4 = new JLabel(this.nombre_platos[1]+": ");
        panel2.add(etiqueta4);
        this.campo2 = new JTextField(10);
        panel2.add(this.campo2);
        JLabel etiqueta5 = new JLabel(this.nombre_platos[2]+": ");
        panel2.add(etiqueta5);
        this.campo3 = new JTextField(10);
        panel2.add(this.campo3);

        this.button1 = new JButton("Presiona para enviar el pedido");
        this.button1.addActionListener(this);
        panel2.add(this.campo3);
        
        this.contenedor.add(panel2);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setVisible(true);

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
        System.out.println(e.getStateChange());

        if(e.getStateChange()==1){
            
            if(e.getSource()==this.combo){
               String name_fish[] = { "Hamburgesa","Limonada","Ensalada Griega"  };
               for (int j = 0; j<3; j++) {
                 if(this.combo.getSelectedItem() == name_fish[j]){
                    Platos name;
                    for(int i = 0; i<1; i++){
                        name = lista4.get(j);
                        JOptionPane.showMessageDialog(this.contenedor, name.getNombre() + " \n" + name.getDescripcion() +
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
