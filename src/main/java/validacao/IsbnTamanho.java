package validacao;

import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.exceptions.IsbnExceptions;

public class IsbnTamanho implements ValidacaoNovoLivro {

	@Override
	public LivroVO validar(LivroVO livroVO) throws IsbnExceptions {

		if (livroVO.getIsbn().length() < 10) {
			throw new IsbnExceptions("ISBN tem que ter mais de 10 digitos.");
			
		}if (livroVO.getIsbn().length() > 13) {
			throw new IsbnExceptions("ISBN tem que ter menos de 13 digitos");
		}
		return livroVO;
	}

}
