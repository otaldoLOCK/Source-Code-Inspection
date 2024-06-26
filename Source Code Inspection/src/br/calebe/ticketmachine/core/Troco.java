package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        while (valor >= 100) {
        valor -= 100;  // Subtraindo 100 do valor enquanto for possível
        count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        int count = 0;
while (valor % 50 != 0) {
    valor -= 50; // Subtrai 50 do valor enquanto não for divisível por 50
    count++; // Conta uma nota de 50
}
papeisMoeda[4] = new PapelMoeda(50, count);

        count = 0;
        while (valor % 20 != 0) {
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        int count = 0;
    while (valor % 10 != 0) {
      valor -= 10; // Subtrai 10 do valor enquanto não for divisível por 10
      count++; // Conta uma nota de 10
  }
    papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor % 5 != 0) {
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        int count = 0;
while (valor % 2 != 0) {
    valor -= 2; // Subtrai 2 do valor enquanto não for divisível por 2
    count++; // Conta uma moeda de 2
}
papeisMoeda[0] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
        for (int i = 5; i >= 0; i--) { // Correção: alterado o i++ para i--
        if (troco.papeisMoeda[i] != null) {
            return true;
        }
    }
    return false;
}

        @Override
        public PapelMoeda next() {
    PapelMoeda ret = null;
    for (int i = 5; i >= 0; i--) { // Correção: alterado o i++ para i--
        if (troco.papeisMoeda[i] != null) {
            ret = troco.papeisMoeda[i];
            troco.papeisMoeda[i] = null;
            break; // Adicionado para sair do loop assim que uma nota válida for encontrada
        }
    }
    return ret;
}

        @Override
        public void remove() {
            next();
        }
    }
}
