package bot.estados;

import bot.dao.PorcoesDAO;
import java.util.List;

public class EstadoPorcoes extends Estado {

    @Override
    public void processaTexto(String texto) {
        
        List<String> opcoes = new PorcoesDAO().recuperaOpcoesPorcoes();
        
        try{
            int opcao = Integer.parseInt(texto.trim()) - 1;
            mensagemResposta = "legal, voce escolheu porção de " + opcoes.get(opcao) + "." + System.lineSeparator() +
                                "Quantas deseja?";
            proximoEstado = new EstadoQuantidade(opcoes.get(opcao));
        } catch (Exception e){
            mensagemResposta = "Por favor, escolha uma opção válida!";
            proximoEstado = this;
        }
        
    }
    
}
