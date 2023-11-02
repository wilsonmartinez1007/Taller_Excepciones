import java.awt.Container;
import java.awt.GridLayout;

import java.util.List;


public class App {
    Container contenedor;
    GridLayout layout;

    static List<Platos> lista4 = new ArrayList<>();

    App(){
        contenedor = getContentPane();
        layout = new GridLayout(3,0)
        contenedor.setLayout(layout);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);

    }


    public static void main(String[] args) throws Exception {
        Platos plato1 = new Platos("Hamburgesa", "no se la verdad", Tipo_plato.Plato_fuerte, 8000, (byte)30);
        Platos plato2 = new Platos("Limonada", "Jugo fresco con sabor a limonada", Tipo_plato.Bebida, 1500, (byte)10);
        Platos plato3 = new Platos("Postre", "tampoco se la verdad", Tipo_plato.Entrada, 8000, (byte)30);
        lista4.add(0, plato1);
        lista4.add( 1, plato2);
        lista4.add(2, plato3);

        App app = new App();
    }
}
