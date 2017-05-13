package bot.estados;

import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoInicial extends Estado{

    @Autowired
    private EstadoEscolhendo estadoEscolhendo;
    
    @Override
    public void processaTexto(String texto) {
        mensagemResposta = "Olá, Seja bem vindo ao Laboratório do Chopp!" + System.lineSeparator() + 
                           "Sou o seu garçom virtual, e estou aqui para ajuda-lo a escolher seu pedido." + System.lineSeparator() +
                           "Vamos lá, escolha:" + System.lineSeparator() + 
                           "1 - Para BEBIDAS," + System.lineSeparator() +
                           "2 - Para ESPETINHOS," + System.lineSeparator() +
                           "3 - Para PORÇÕES";
        proximoEstado = estadoEscolhendo;
    }

    
}
