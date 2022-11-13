package validacao;

import com.estudos.MyBooksProject.entity.LivroVO;

public interface ValidacaoNovoLivro {
	
	public LivroVO validar(LivroVO livro) throws Exception;

}
