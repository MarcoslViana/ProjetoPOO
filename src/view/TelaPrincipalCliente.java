import javax.swing.*;
import java.awt.event.*;
import model.Loja;

public class TelaPrincipalCliente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton listaButton;
    private JButton adicionarClienteButton;
    private JButton voltarButton;

    private LojaDao lojaDao;
    private Loja loja;

    public TelaPrincipalCliente(Loja loja) {
        lojaDao = new LojaDao();
        this.loja =loja;
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        adicionarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAdicionaCliente telaAdicionaCliente = new TelaAdicionaCliente(lojaDao.getLoja());
                telaAdicionaCliente.pack();
                telaAdicionaCliente.setVisible(true);
                setVisible(false);
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.pack();
                telaPrincipal.setVisible(true);
            }
        });

    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }
}
