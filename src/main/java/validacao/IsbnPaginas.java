package validacao;

import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.exceptions.LivroSemPaginaException;

public class IsbnPaginas implements ValidacaoNovoLivro {

	@Override
	public LivroVO validar(LivroVO livro) throws LivroSemPaginaException {
		if (livro.getPaginas() < 1) {
			throw new LivroSemPaginaException("A quantidade de paginas deve ser superior a 0.");
		}
		return livro;
	}

}
