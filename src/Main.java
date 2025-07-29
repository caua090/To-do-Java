import OOP.ArquivoText;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        /*1-criar menu de navegação
        * 2- criar a possibildiade do usuario criar seus afazeres pendentes
        * 3- mostrar todos os afazeres do usuario
        * 4- selecionar um afazer e marca-lo como feito
        * 5- mostrar todos os afazeres marcado como feito*/
        ArquivoText funcao = new ArquivoText();

        while(funcao.isLigado()){
            System.out.println("""
                    Bem vindo ao sistema de TO-DO LIST
                    1-Criar suas tarefas pendentes
                    2-Motrar todos seus afazeres
                    3-Selecione seu afazer para marca-lo como feito
                    4-Veja todos seus Afazeres concluidos
                    5-Sair""");
            Scanner entrada = new Scanner(System.in);


            //escolha de opção
            byte escolha = entrada.nextByte();

            switch (escolha){
                case 1:
                    System.out.println("Crie sua tarefa pendente: ");
                    //criando tarefa pendenete
                    Scanner tarefaPendente = new Scanner(System.in);
                    //adicionando taferea em dados
                    funcao.setDados(tarefaPendente.nextLine());

                    //cria o arquivo
                    funcao.CriarArquivo();
                    funcao.Continuar();

                    break;
                case 2:
                    //Ler arquivo TXT

                    funcao.LerArquivo();

                    funcao.Continuar();



                    break;
                case 3:
                    funcao.LerArquivo();
                    System.out.println("Qual tarefa esta concluida (considere o primeiro item como 0): ");
                    Scanner escolhaUsuario = new Scanner(System.in);
                    funcao.setEscolhaUsuarioConcluirTarefa(escolhaUsuario.nextInt());
                    funcao.DadosArray();
                    funcao.Continuar();
                    break;
                case 4:
                    funcao.LerArquivoConcluido();
                    funcao.Continuar();
                    break;
                case 5:
                    funcao.setLigado(false);
                    break;
                default:
                    System.out.println("Você não escolheu uma opção valida");
            }



        }
        }



}