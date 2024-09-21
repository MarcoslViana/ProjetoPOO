import javax.swing.*;
import java.awt.event.*;

public class TelaPrincipalFuncionario extends JDialog {
    private JPanel contentPane;
    private JButton adicionarFuncionarioButton;
    private JButton listaButton;
    private JButton voltarButton;
    private LojaDao lojaDao;

    public TelaPrincipalFuncionario() {

        lojaDao = new LojaDao();
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(adicionarFuncionarioButton);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        adicionarFuncionarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAdicionaFuncionario telaAdicionaFuncionario = new TelaAdicionaFuncionario(lojaDao.getLoja());
                telaAdicionaFuncionario.pack();
                telaAdicionaFuncionario.setVisible(true);
                setVisible(false);
            }
        });

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.pack();
                telaPrincipal.setVisible(true);
                setVisible(false);
            }
        });

        listaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaListaFuncionario telaListaFuncionario = new TelaListaFuncionario();
                telaListaFuncionario.pack();
                telaListaFuncionario.setVisible(true);
                setVisible(false);
            }
        });
    }
}
