package OOP;

import java.io.*;
import java.util.*;

public class ArquivoText {
    //local onde salva o arquivo
    private final String nomeArquivo = "D:\\backUp\\java\\to-do-list\\dados\\dados.txt";
    private final String nomeArquivoConcluido = "D:\\backUp\\java\\to-do-list\\dados\\dados_concluidos.txt";


    //variavel que recebe os dados de tarefaPendente
    public String dados;

    public boolean ligado = true;

    public int escolhaUsuarioConcluirTarefa;

    //função para criar o arquivo
    public void CriarArquivo(){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo,true));
            //escreve o que o usuario escrever e quebra a linha
            writer.write(dados+"\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

    //função para ler o arquivo
    public void LerArquivo(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            //le uma linha
            String leitor = reader.readLine();

            //repete a leitura linha por linha até ler todoas as linhas do arquivo
            while (leitor != null){
                System.out.println(leitor);
                leitor = reader.readLine();
            }

        } catch (Exception error){
            System.out.println(error.getMessage());
        }

    }
    //função para perguntar se continua rodando o while ou não
    public void Continuar(){

        System.out.println("deseja continuar (Sim ou Nao): ");

        Scanner continuar = new Scanner(System.in);

        String resposta = continuar.nextLine();

        boolean b = resposta.equals("nao");
        if (b){
            setLigado(false);

        }

    }

    public void DadosArray(){
        //cria lista de string
        List<String> lista = new ArrayList<>();


        //mesma estrutura do LerArquivo
        try{
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));
            String leitor = reader.readLine();

            //while que coloca todas as linhas do arquivos dados.txt na lista
            while (leitor != null){
                lista.add(leitor);
                leitor = reader.readLine();

            }
        } catch (Exception error){
            System.out.println(error.getMessage());}

        System.out.println("tarefa registrada como concluida");

        //mesma estrutura de escrever arquivos criando novo arquivo para tarefas concluidas
        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivoConcluido, true));
            writer.write(lista.get(escolhaUsuarioConcluirTarefa) + "\n");
            writer.close();
            //remove a linha que o usuario escolheu como tarefa concluida
            lista.remove(escolhaUsuarioConcluirTarefa);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {


            int tamanhoLista = lista.size();
            //zera o conteudo do arquivo dados.txt
            BufferedWriter esvaziar = new BufferedWriter(new FileWriter(nomeArquivo));
            esvaziar.write("");
            //escreves os dados novamente sem incluir o dado que o usuario escolheu como concluido
            for(int indice = 0; indice < tamanhoLista; indice++){
                BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo,true));
                writer.write(lista.get(indice)+"\n");
                writer.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void LerArquivoConcluido(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivoConcluido));
            //le uma linha
            String leitor = reader.readLine();

            //repete a leitura linha por linha até ler todoas as linhas do arquivo
            while (leitor != null){
                System.out.println(leitor);
                leitor = reader.readLine();
            }

        } catch (Exception error){
            System.out.println(error.getMessage());
        }

    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public void setEscolhaUsuarioConcluirTarefa(int escolhaUsuarioConcluirTarefa) {
        this.escolhaUsuarioConcluirTarefa = escolhaUsuarioConcluirTarefa;
    }
}
