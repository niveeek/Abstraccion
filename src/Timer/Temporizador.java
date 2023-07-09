package Timer;
import beans.Persona;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JOptionPane;
public final class Temporizador {
    //ATRIBUTOS
    private final short delay;
    private final boolean beepSound;
    private final Persona persona;
    private ActionListener actionListener;
    //CONSTRUCTOR
    public Temporizador(final short delay, final boolean beepSound, final Persona persona) {
        this.delay = delay;
        this.beepSound = beepSound;
        this.persona = persona;
    }
    //MÉTODO EXTERNO 1
    public void iniciar(){
        actionListener = new Listener(); //UPCASTING
        if(actionListener instanceof Listener) {
            Timer timer = new Timer(delay, actionListener);
            timer.start();
        } else {
            System.exit(0);
        }
    }
    //MÉTODO EXTERNO 2
    public void terminar(){
        //CLASE INTERNA 1 DENTRO DE MÉTODO 2 DE CLASE EXTERNA
        class Mensaje {
            public static void mensajeStop(){
                JOptionPane.showMessageDialog(null,"Stop");
            }
        }
        Mensaje.mensajeStop();
        ///CLASE INTERNA 2 DENTRO DE MÉTODO 2 DE CLASE EXTERNA QUE HEREDA CLASE INTERNA 1
        final class Mensaje2 extends Mensaje{
            //MÉTODO INTERNO 1 DE CLASE INTERNA 2
            public static void mensajeStopClicked(){
                JOptionPane.showMessageDialog(null,"Stop clicked");
            }
        }
        Mensaje2.mensajeStopClicked();
        Listener listener = (Listener) actionListener; //DOWNCASTING
        Listener.Mensaje3 m3 = listener.new Mensaje3(); //JERARQUÍA DE CLASES INTERNAS POR INSTANCIA
        m3.mensajeMetodo3();
        Listener.Mensaje3.mensajeMetodo5(); //JERARQUÍA DE CLASES INTERNAS POR ESTÁTICA
        if (listener instanceof Listener) {
            listener.systemExit();
        } else {
            System.exit(0);
        }
    }
    public void proceso(){
        iniciar();
        terminar();
    }
    //CLASE INTERNA
    private final class Listener implements ActionListener {
        //MÉTODO IMPLEMENTADO ACTIONLISTENER
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(persona);
            if (beepSound){
                Toolkit.getDefaultToolkit().beep();
            }
        }
        public void systemExit(){
            //CLASE INTERNA 1 DENTRO DE MÉTODO 1 DENTRO DE CLASE INTERNA LISTENER DENTRO DE CLASE EXTERNA
            final class Mensaje4 {
                public static void mensajeMetodo4(){
                    JOptionPane.showMessageDialog(null,"End Program");
                }
            }
            Mensaje4.mensajeMetodo4();
            System.exit(0);
        }
        //CLASE INTERNA 2 PRIVADA 2 DENTRO DE CLASE PRIVADA INTERNA 1 DENTRO DE CLASE EXTERNA
        private final class Mensaje3 {
            public void mensajeMetodo3(){
                JOptionPane.showMessageDialog(null,"Mid Program");
            }
            public static void mensajeMetodo5(){
                JOptionPane.showMessageDialog(null,"Mid-Upper Program");
            }
        }
    }
}
