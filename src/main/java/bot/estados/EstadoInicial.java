package bot.estados;

import bot.cliente.Cliente;
import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

public class EstadoInicial extends Estado{

    private Cliente c;

    public EstadoInicial(ApplicationContext context, Cliente c) {
        super(context);
        this.c = c;
    }
    
    @Override
    public void processaTexto(String texto) {
        mensagemResposta = "Olá," + c.getFirst_name() + " " + c.getLast_name() + ", seja bem vindo ao Laboratório do Chopp!" + System.lineSeparator() + 
                           "Voce eh um cliente " + c.getStatus()  + System.lineSeparator() + 
                           "Sou o seu garçom virtual, e estou aqui para ajuda-lo a escolher seu pedido." + System.lineSeparator() +
                           "Vamos lá, escolha:" + System.lineSeparator() + 
                           "1 - Para BEBIDAS," + System.lineSeparator() +
                           "2 - Para ESPETINHOS," + System.lineSeparator() +
                           "3 - Para PORÇÕES";
        proximoEstado = new EstadoEscolhendo(context);
    }

    
}
