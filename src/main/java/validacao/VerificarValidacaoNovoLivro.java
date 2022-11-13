package validacao;

import java.util.ArrayList;
import java.util.List;

import com.estudos.MyBooksProject.entity.LivroVO;

public class VerificarValidacaoNovoLivro {

	public LivroVO validacaoNovoLivro(LivroVO livroVO) throws Exception {
		// recebe a interface como parametro, e cada classe que à implementa tera seu
		// codigo especifico
		List<ValidacaoNovoLivro> validacoesNovosLivros = new ArrayList<ValidacaoNovoLivro>();
		

		validacoesNovosLivros.add(new IsbnIsNumeric());
		validacoesNovosLivros.add(new IsbnPaginas());
		validacoesNovosLivros.add(new IsbnTamanho());
		for(ValidacaoNovoLivro item : validacoesNovosLivros) {
			item.validar(livroVO);
		}

		return livroVO;
	}

}
