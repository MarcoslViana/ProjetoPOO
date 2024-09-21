import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import model.Loja;
import model.Cliente;
import model.Funcionario;
import java.util.List;


public class TelaListaClientes extends JDialog {
    private JPanel contentPane;
    private JButton sairButton;
    private JTable table1;

    public TelaListaClientes(Loja loja) {
        setContentPane(contentPane);
        //setModal(true);
        getRootPane().setDefaultButton(sairButton);

    }

    private void createUIComponents() {
        table1 = new JTable();
        preencherTabela();
    }

    private void preencherTabela() {
        LojaDao lojaDao1 = new LojaDao();
        String titulos[] = { "Nome","CPF", "Telefone", "Endereço"};
        List<Cliente> clientes = lojaDao1.getLoja().getClientes();
        List<Cliente> clienteList = clientes.stream().toList();
        String dados[][] = new String[clientes.size()][4];

        for(int i=0; i<clientes.size(); i++) {
            dados[i][0] = clienteList.get(i).getNome();
            dados[i][1] = clienteList.get(i).getCpf();
            dados[i][2] = clienteList.get(i).getTelefone();
            dados[i][3] = clienteList.get(i).getEndereco();
        }

        DefaultTableModel model = new DefaultTableModel(dados, titulos);
        table1.setModel(model);
    }
}
