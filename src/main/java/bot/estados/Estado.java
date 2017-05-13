package bot.estados;

public abstract class Estado {
     protected String mensagemResposta;
     protected Estado proximoEstado;
     
    public abstract void processaTexto(String texto);
    
    public String getMensagemResposta() {
        return mensagemResposta;
    }

    public Estado getProximoEstado() {
        return proximoEstado;
    }   
}
