import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    static List<Bilhete>bilhetes = new ArrayList<Bilhete>();

    static List<Pessoa>pessoas = new ArrayList<Pessoa>();


    Scanner imput = new Scanner(System.in);



    public void menu() {



        int opcoes = 0;

        int guardarTipoBilhete;

        String nome,telefone,email,cpf;

        String codigoDoBilhete;


        do {
            //aqui coloquei os textos para o do reconhecelos
            System.out.println("--menu--");
            System.out.println("1 cadastrar usuario: ");
            System.out.println("2 cadastrar bilhete: ");
            System.out.println("3 recarregar bilhete: ");
            System.out.println("4 pagar passagem: ");
            System.out.println("5 listar bilhete: ");
            System.out.println("6 pesqisar bilhete por cpf : ");
            System.out.println("99 para sair: ");

            //try catch serve pra pegar um possivel erro e mostrar uma mensagem no caso"codio invalido insira um numero"
            try{
                opcoes = imput.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("valor invalido,insira um número");
                imput.next();
            }

            switch (opcoes) {

                case 1:
                    imput.nextLine();
                    System.out.println("opção 1 selecionada: ");
                    System.out.println("digite seu nome: ");

                    nome = imput.nextLine();
                    System.out.println("digite seu telefone: ");

                    telefone = imput.nextLine();
                    System.out.println("digite seu cpf: ");

                    cpf = imput.nextLine();
                    System.out.println("digite seu email: ");

                    email = imput.nextLine();
                    Pessoa pessoa = new Pessoa(nome, cpf, email, telefone);
                    pessoas.add(pessoa);
                    break;

                case 2:
                    System.out.println(" 2= Cadastrar Bilhete ");
                    imput.nextLine();
                    System.out.println("Insira Seu CPF");
                    String cpf2 = imput.nextLine();
                    Pessoa p1 = null;
                    boolean achou = false;
                    for (Pessoa p:pessoas){
                        if (cpf2.equals(p.getCpf())){
                            p1 = p;
                            achou = true;

                        }
                    }
                    if (!achou) {
                        System.out.println("CPF Inálido. Tente Novamente");


                    }else {
                        System.out.println("Qual Tipo de Bilhete Voce Deseja Obter?");
                        System.out.println("1 = Bilhete Estudante");
                        System.out.println("2 = Bilhete Padrao");
                        guardarTipoBilhete = imput.nextInt();
                        Bilhete b1;
                        if (guardarTipoBilhete == 1) {
                            b1 = new BilheteEstudantes(p1);
                            System.out.println("BILHETE ESTUDANTE CADASTRADO");

                        }else {
                            b1 = new BilheteUnicoPadrao(p1);
                            System.out.println("BILHETE ÚNICO CADASTRADO");
                        }
                        bilhetes.add(b1);
                    }
                    break;

                case 3:
                    String guardarCodigo;
                    System.out.println("recarregar bilhete: ");
                    achou = false;
                    System.out.println("informe seu código: ");
                    imput.nextLine();
                    guardarCodigo = imput.nextLine();
                    Bilhete b2 = null;
                    for (Bilhete value : bilhetes) {
                        if (guardarCodigo.equals(value.getCodigoDoBilhete())) {
                            b2 = value;
                            achou = true;
                        }
                    }
                    if (achou == false) {
                        System.out.println("código inválido informe outro código: ");
                    } else {

                        if (b2 instanceof BilheteEstudantes) {
                            b2.recarregarBilhete();
                        } else {
                            System.out.println("insira o valor de recarga: ");
                            double guardarValor = imput.nextDouble();
                            b2.recarregarBilhete(guardarValor);
                        }
                    }
                    break;

                case 4:
                    achou = false;
                    imput.nextLine();
                    System.out.println("informe seu código: ");
                    String codigoDobilhete = imput.nextLine();
                    b2 = null;
                    for (Bilhete value : bilhetes) {
                        if (codigoDobilhete.equals(value.getCodigoDoBilhete())) {
                            b2 = value;
                            achou = true;
                        }
                    }
                    if (achou == false) {
                        System.out.println("código inválido informe outro código: ");
                    } else {
                        b2.pagarPassagem();
                    }
                    break;

                case 5:
                    System.out.println("listar bilhete: ");
                    imput.nextLine();

                    System.out.println("sua lista de bilhetes: ");
                    for (Bilhete bilhete:bilhetes
                         ) {
                        System.out.println(bilhete);
                    }
                    break;

                case 6:
                    String nada = imput.nextLine();
                    System.out.println("Digite o cpf do usuario a ser pesquisado : ");
                    String salvarCpf = imput.nextLine();
                    Bilhete salvar = null;
                    boolean achei = false;
                    for (Bilhete bilhete : bilhetes) {

                        if(salvarCpf.equals(bilhete.getUsuario().getCpf())) {
                            salvar = bilhete;
                            achei = true;
                        }
                    }
                    if (achei == true)
                        System.out.println("esse é o bilhete: " + salvar);
                        else
                        System.out.println("CPF não encontrado: ");
                    break;

                case 99:
            }
        }while (opcoes != 99);

    }

}
