
public class FilaInteirosInfinita {

	private int[] vetor = new int[20];
	private int posicao = 0;

	public void incluir(int valor) {
		if (posicao < vetor.length) {
			vetor[posicao] = valor;
			posicao++;
		} else {
			expandir();
			incluir(valor);
		}
	}

	public void expandir() {
		int[] vetoraux = new int[vetor.length];
		for (int i = 0; i < vetoraux.length; i++) {
			vetoraux[i] = vetor[i];
		}
		vetor = new int[vetor.length + 20];
		for (int i = 0; i < vetoraux.length; i++) {
			vetor[i] = vetoraux[i];
		}
	}

	public Object remover() throws FilaVaziaException {
		if (vetor[0] == 0) {
			throw new FilaVaziaException();
		} else {
			int retorno = vetor[0];
			for (int i = 0; i < vetor.length - 1; i++) {
				vetor[i] = vetor[i + 1];
			}
			posicao--;
			return retorno;
		}
	}

	public int getQtd() {
		return posicao;
	}

	public int getQtdMaxSuportada() {
		return vetor.length;
	}

	public boolean estaVazia() {
		if (posicao == 0) {
			return true;
		} else
			return false;
	}

	public void limpar() {
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = 0;
		}
		posicao = 0;
	}

	public Object visualizarProximo() throws FilaVaziaException {
		if (estaVazia()) {
			throw new FilaVaziaException();
		} else
			return vetor[0];
	}

}
