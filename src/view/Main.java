
import model.Cliente;
import model.Funcionario;
import model.Loja;
import model.Produto;

public class Main{

    public static void main(String[] args){

        Loja loja = new Loja();

        loja.adicionarCliente(new Cliente("Gabriel","123.123.123-12","8399292-9595","Rua das Ostras"));
        loja.adicionarProduto(new Produto("Camisa vermelha", "123",123,15,"Nike"));

//        for (Cliente cliente : loja.getClientes()){
//            if(cliente.getCpf().equals("123.123.123-12")){
//                System.out.println("Não foi possível adicionar esse cliente pois ja existe um usuario com esse cpf");
//            }else{
//                loja.adicionarFuncionario(new Funcionario("Adeilton","155.155.155-15","Zelador"));
//            }
//        }


        System.out.println(loja);
    }
}
