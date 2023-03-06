package Mentorama.DesafioMod8Resolvido.DB;
import Mentorama.DesafioMod8Resolvido.Models.Conta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContasDB {
    private Map<Integer, Conta> contasDBmap = new HashMap<>();

    public List<Conta> getContas() {
        List<Conta> contas = new ArrayList<>();

        for(Map.Entry<Integer, Conta> conta : contasDBmap.entrySet()) {
            contas.add(conta.getValue());
        }

        return contas;
    }

    public void addNovaConta(Conta conta) {
        contasDBmap.put(conta.getNumeroConta(), conta);
    }

    public Conta getContaPorNumero(int numeroConta){
        return contasDBmap.get(numeroConta);
    }
}
