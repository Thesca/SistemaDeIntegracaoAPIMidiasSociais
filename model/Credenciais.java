package model;

import java.util.HashMap;
import java.util.Map;

// Flexível para suportar qualquer tipo de autenticação
public class Credenciais {
    private Map<String, String> chaves = new HashMap<>();

    public void set(String chave, String valor) {
        this.chaves.put(chave, valor);
    }
    
    public String get(String chave) {
        return this.chaves.getOrDefault(chave, "");
    }
}