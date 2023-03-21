public class BilheteEstudantes extends Bilhete {

    private double cota;

    public BilheteEstudantes(Pessoa usuario) {
        super(usuario);
    }

    @Override
    public void recarregarBilhete() {
        cota = 48 + cota;
    }

    @Override
    public void pagarPassagem() {
        cota = cota - 1;
    }
    public String toString(){
        String dados = "";
        dados += "dados do usuario: " + this.usuario.getNome() + (" ");
        dados += "codigo do bilhete: " + this.codigoDoBilhete + (" ");
        dados += "cota: " + this.cota + (" ");

        return dados;

    }
}