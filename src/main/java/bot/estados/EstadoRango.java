package bot.estados;

class EstadoRango extends Estado {

    @Override
    public void processaTexto(String texto) {
        mensagemResposta = "Legal, vc esta com fome!!";
        proximoEstado = this;
    }  
    
}
