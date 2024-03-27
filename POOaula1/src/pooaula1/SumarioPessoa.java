
package pooaula1;

import java.util.ArrayList;

public final class SumarioPessoa {
    int quantidade, idadeMenor, idadeMaior;
    float media, percMaiores, percMenores;
    String nomeMaior, nomeMenor;
    //ArrayList<Pessoa> pessoas;
    
    SumarioPessoa(ArrayList<Pessoa> pessoas){
        //this.pessoas = pessoas;
        quantidade = pessoas.size();
        if(quantidade > 0){
            media = CalcularMedia(pessoas);
            nomeMaior = MaisVelho(pessoas).nome;
            idadeMaior = MaisVelho(pessoas).calcularIdade();
            nomeMenor = MaisNovo(pessoas).nome;
            idadeMenor = MaisNovo(pessoas).calcularIdade();
            percMenores = percMenor(pessoas);
            percMaiores = percMaior(pessoas);
        }
    }
    
    float CalcularMedia(ArrayList<Pessoa> p){
        float soma = 0;
        for(int i = 0; i < p.size(); i++){
            soma += p.get(i).calcularIdade();
        }
        
        if(p.size() > 0)
            return soma / p.size();
        
        return 0;
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
        for(int i = 1; i < p.size(); i++){
            if(p.get(i).calcularIdade() > pessoa.calcularIdade())
                pessoa = p.get(i);
        }
        
        return pessoa;
    }
    
    float percMaior(ArrayList<Pessoa> pessoas){
        int cont = 0;
        for(Pessoa p: pessoas){
            if(p.calcularIdade() >= 18)
                cont++;
        }
        
        if(cont > 0)
            return (float) cont / pessoas.size() * 100;
        
        return 0;
    }
    
    float percMenor(ArrayList<Pessoa> pessoas){
        int cont = 0;
        
        for(Pessoa p: pessoas){
            if(p.calcularIdade() < 18)
                cont++;
        }
        
        if(cont > 0)
            return (float) cont / pessoas.size() * 100;
        
        return 0;
    }
}
