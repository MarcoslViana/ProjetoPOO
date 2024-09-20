import java.io.*;
import java.util.HashSet;
import java.util.Set;
import model.Loja;

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






}
