
package pooaula1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Pessoa {
    
    String nome;
    Date dataNascimento;
    
    int calcularIdade() {
        Calendar dataNasc = Calendar.getInstance();
        dataNasc.setTime(dataNascimento);
        
        Calendar hoje = Calendar.getInstance();
        hoje.getTime();
        
        int idade = hoje.get(Calendar.YEAR) - dataNasc.get(Calendar.YEAR);
        
        dataNasc.add(Calendar.YEAR, idade);
        
        if (hoje.before(dataNasc)) {
            idade--;
        }
        
        return idade;
    }
    
    String imprimir() {
        return "Nome: " + nome + "\nIdade: " + calcularIdade();
    }
    
    float CalcularMedia(ArrayList<Pessoa> p){
        float media = 0;
        float soma = 0;
        for(int i = 0; i < p.size(); i++){
            soma += p.get(i).calcularIdade();
        }
        
        if(p.size() > 0)
            media = soma / p.size();
        
        return media;
    }
    
    Pessoa MaisNovo(ArrayList<Pessoa> p){
        Pessoa pessoa = p.get(0);
        
        for(int i = 1; i < p.size(); i++){
            if(p.get(i).calcularIdade() < pessoa.calcularIdade())
                pessoa = p.get(i);
        }
        
        return pessoa;
    }
    
    Pessoa MaisVelho(ArrayList<Pessoa> p){
        Pessoa pessoa = p.get(0);
        
        for(int i = 1; i < p.size() - 1; i++){
            if(p.get(i).calcularIdade() > pessoa.calcularIdade())
                pessoa = p.get(i);
        }
        
        return pessoa;
    }
}
