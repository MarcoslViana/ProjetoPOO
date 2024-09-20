import model.Cliente;
import model.Loja;
import javax.swing.*;
import java.awt.event.*;

public class TelaAdicionaCliente extends JDialog {
    private JPanel contentPane;
    private JButton salvarButton;
    private JButton cancelarButton;
    private JTextField inputNome;
    private JTextField inputTelefone;
    private JTextField inputCPF;
    private JTextField inputEndereco;
    private Loja loja;
    private LojaDao lojaDao;


    public TelaAdicionaCliente(Loja loja) {
        this.loja =loja;
        lojaDao = new LojaDao();
        setContentPane(contentPane);
        setModal(true);
        pack();
        getRootPane().setDefaultButton(salvarButton);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                onCancel();
//            }
//        });

        // call onCancel() on ESCAPE
//        contentPane.registerKeyboardAction(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onCancel();
//            }
//        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = inputNome.getText();
                String cpf = inputCPF.getText();
                String endereco = inputEndereco.getText();
                String telefone = inputTelefone.getText();

                Cliente cliente = new Cliente(nome,cpf,telefone,endereco);
                loja.adicionarCliente(cliente);
                if(lojaDao.atualizarLoja(loja)){
                    JOptionPane.showMessageDialog(contentPane,"Cliente adicionado com sucesso!");
                    dispose();
                }else {
                    JOptionPane.showMessageDialog(contentPane,
                            "Falha ao adicionar cliente",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });


        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente(lojaDao.getLoja());
                setVisible(false);
                telaPrincipalCliente.pack();
                telaPrincipalCliente.setVisible(true);
            }
        });
    }

}
