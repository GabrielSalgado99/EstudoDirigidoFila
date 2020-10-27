
public class Fila implements IFila {

	private Object[] vetor = new Object[20];
	private int posicao = 0;

	@Override
	public void incluir(Object valor) throws FilaCheiaException {
		if (posicao < vetor.length) {
			vetor[posicao] = valor;
			posicao++;
		} else {
			throw new FilaCheiaException();
		}
	}

	@Override
	public Object remover() throws FilaVaziaException {
		if (vetor[0] == null) {
			throw new FilaVaziaException();
		} else {
			Object retorno = vetor[0];
			for (int i = 0; i < vetor.length - 1; i++) {
				vetor[i] = vetor[i + 1];
			}
			posicao--;
			return retorno;
		}
	}

	@Override
	public int getQtd() {
		return posicao;
	}

	@Override
	public int getQtdMaxSuportada() {
		return vetor.length;
	}

	@Override
	public boolean estaVazia() {
		if (posicao == 0) {
			return true;
		} else
			return false;
	}

	@Override
	public void limpar() {
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = null;
		}
		posicao = 0;
	}

	@Override
	public Object visualizarProximo() throws FilaVaziaException {
		if (estaVazia()) {
			throw new FilaVaziaException();
		} else
			return vetor[0];
	}
}
