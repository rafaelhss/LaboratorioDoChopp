package bot.estados;

import bot.dao.EspetinhoDAO;
import java.util.List;

public class EstadoEspetinho extends Estado {
    
    @Override
    public void processaTexto(String texto) {
        
        List<String> opcoes = new EspetinhoDAO().recuperaOpcoesEspetinhos();
        
        try{
            int opcao = Integer.parseInt(texto.trim()) - 1;
            mensagemResposta = "legal, voce escolheu " + opcoes.get(opcao) + "." + System.lineSeparator() +
                                "Quantos deseja?";
            proximoEstado = new EstadoQuantidade(opcoes.get(opcao));
        } catch (Exception e){
            mensagemResposta = "Por favor, escolha uma opção válida!";
            proximoEstado = this;
        }
        
    }
            
}
