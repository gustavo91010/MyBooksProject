package validacao;

import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.exceptions.IsbnExceptions;

public class IsbnIsNumeric implements ValidacaoNovoLivro {

	@Override
	public LivroVO validar(LivroVO livroVO) throws IsbnExceptions {
		boolean isNumeric = livroVO.getIsbn().matches("[+-]?\\d*(\\.\\d+)?");
		if (!isNumeric) {
			throw new IsbnExceptions("ISBN nao pode conter letras");
		}
		return livroVO;

	}

}
