import java.util.Random;

public abstract class Bilhete {

    //aqui são meus atributos:
    protected String codigoDoBilhete;

    protected Pessoa usuario;

    //aqui são meus metodos:
    //método contrutor é um metodo que tem o mesmo nome da classe;
    public Bilhete(Pessoa usuario) {
        this.codigoDoBilhete = gerarCodigo();
        this.usuario = usuario;
    }
    public String gerarCodigo() {
        double bilhete;
        Random random = new Random();
        bilhete = (int)(random.nextDouble() * 1000);

        return String.valueOf(bilhete);
    }

    public Pessoa getUsuario() {
        return usuario;
    }

    public String getCodigoDoBilhete() {
        return codigoDoBilhete;
    }

    public void pagarPassagem() {

    }

    public void recarregarBilhete() {

    }

    public void recarregarBilhete(double valor) {

    }

}

