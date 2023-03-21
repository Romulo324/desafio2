import java.util.Random;

public class BilheteUnicoPadrao extends Bilhete {

        private double saldo;


        public BilheteUnicoPadrao(Pessoa usuario) {
            super(usuario);
        }

        @Override
        public void recarregarBilhete(double valor) {
            saldo = valor + saldo;
        }

    @Override
    public void pagarPassagem() {
         saldo = saldo - 5;
    }


    public String toString(){
            String dados = "";
            dados += "dados do usuario: " + this.usuario.getNome() + (" ");
            dados += "codigo do bilhete: " + this.codigoDoBilhete + (" ");
            dados += "saldo: " + this.saldo + (" ");

            return dados;

    }

}

