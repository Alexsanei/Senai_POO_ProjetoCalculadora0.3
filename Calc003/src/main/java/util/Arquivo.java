/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class Arquivo {
    private static final String nomeArquivo = "historico.txt";
    
//    public static void salvarLinha(String texto) {
//        try (FileWriter writer = new FileWriter(nomeArquivo, true)) {
//            writer.write(texto + "\n");
//        }catch (IOException e) {
//            JOptionPane.showMessageDialog(null, 
//                    "Erro ao salvar no arquivo: " + e.getMessage(),
//                    "Erro de arquivo", JOptionPane.ERROR_MESSAGE);
//        }
//    }
    public static boolean excluirArquivo(String nomeArquivo) {
        try {
            File arquivo = new File(nomeArquivo);
            
            // Verifica se o arquivo existe antes de tentar excluir.
            if (arquivo.exists()) {
                // O método delete() retorna true se for bem-sucedido.
                return arquivo.delete();
            } else {
                // Se o arquivo não existe, tecnicamente ele está "limpo", mas retornamos false para indicar que não houve exclusão.
                return false; 
            }
        } catch (SecurityException e) {
            // Em caso de falta de permissão.
            System.err.println("Erro de segurança ao excluir o arquivo: " + e.getMessage());
            return false;
        }
    } 
    
    
    public static void salvarLinha(String texto){
        try (FileWriter writer = new FileWriter(nomeArquivo, true)){
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern(" dd/MM/yyyy HH:mm:ss "));
                writer.write("[" + dataHora + "] " + " → " + texto + " \n");
            }catch (IOException e) {
                System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }
    public static String lerArquivo(){
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))){
        String linha;
            while ((linha = br.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
        }catch (IOException e) {
                conteudo.append("Nenhum histórico encontrado, \n");
        }
        return conteudo.toString();
    }
}