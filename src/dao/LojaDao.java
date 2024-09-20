import java.io.*;
import java.util.List;
import model.Loja;
import model.Cliente;
import model.Produto;
import model.Funcionario;

public class LojaDao {

    private  File arquivo;

    public LojaDao(){
        arquivo = new File("loja.ser");

        if(!arquivo.exists()){
            try {
                arquivo.createNewFile();
            }catch (IOException e){
                System.out.println("Falha ao criar o Arquivo");
            }
        }
    }

    public Loja getLoja(){
        try {
            FileInputStream fileInputStream = new FileInputStream(arquivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Loja loja = (Loja) objectInputStream.readObject();
            return loja;
        }catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado");
        }catch (IOException e){
            System.out.println("Falha ao ler arquivo!");
        }catch (ClassNotFoundException e){
            System.out.println("Falha ao ler arquivo!");
        }
        return new Loja();
    }


    public boolean atualizarLoja(Loja lojaAtualizada){
        Loja loja = getLoja();
        List<Cliente> clientesAtuais = loja.getClientes();
        clientesAtuais = lojaAtualizada.getClientes();

        List<Produto> produtosAtuais = loja.getProdutos();
        produtosAtuais = lojaAtualizada.getProdutos();

        List<Funcionario> funcionariosAtuais = loja.getFuncionarios();
        funcionariosAtuais = lojaAtualizada.getFuncionarios();

        return true;
    }



}
