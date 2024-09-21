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
    private LojaDao lojaDao = new LojaDao();

    public TelaAdicionaCliente(Loja loja) {

        setContentPane(contentPane);
        //setModal(true);
        pack();
        getRootPane().setDefaultButton(salvarButton);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = inputNome.getText();
                String cpf = inputCPF.getText();
                String endereco = inputEndereco.getText();
                String telefone = inputTelefone.getText();

                Cliente cliente = new Cliente(nome,cpf,telefone,endereco);
                loja.adicionarCliente(cliente);
                if(lojaDao.salvarLoja(loja)){
                    JOptionPane.showMessageDialog(contentPane,"Cliente adicionado com sucesso!");
                    TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente(loja);
                    telaPrincipalCliente.pack();
                    telaPrincipalCliente.setVisible(true);
                    setVisible(false);
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
                TelaPrincipalCliente telaPrincipalCliente = new TelaPrincipalCliente(loja);
                telaPrincipalCliente.pack();
                telaPrincipalCliente.setVisible(true);
                setVisible(false);
            }
        });
    }

}
