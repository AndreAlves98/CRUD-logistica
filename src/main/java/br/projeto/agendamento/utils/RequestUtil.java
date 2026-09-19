package br.projeto.agendamento.utils;


import java.util.HashMap;
import java.util.Map;

public class RequestUtil {

    public static Map<String, String> parserMensagem(String mensagem) {
        Map<String, String> saida = new HashMap<>();
        saida.put("Mensagem", mensagem);

        return saida;
    }
}
