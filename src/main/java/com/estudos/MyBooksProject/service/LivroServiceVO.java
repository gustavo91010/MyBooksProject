package com.estudos.MyBooksProject.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.MyBooksProject.converter.DozerConverter;
import com.estudos.MyBooksProject.converter.LivroConverterV2;
import com.estudos.MyBooksProject.entity.Livro;
import com.estudos.MyBooksProject.entity.LivroVO;
import com.estudos.MyBooksProject.entity.LivroVOV2;
import com.estudos.MyBooksProject.repository.LivroRepository;

@Service
public class LivroServiceVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private LivroRepository repository;
	@Autowired
	private LivroConverterV2 converter;

	private LivroVO livroVO = new LivroVO();
//	private List<LivroVO> livrosVO= new ArrayList<>();

	public LivroVO create(LivroVO livroVO) {
		// recebo um VO
		Livro livro = DozerConverter.parseObject(livroVO, Livro.class);
		// converto ele para livro
		LivroVO vo = DozerConverter.parseObject(repository.save(livro), LivroVO.class);
		// valso ele como livro no banco de dados, e conveto novamente para VO
		return vo;
		// retorno meu vo

	}
	public LivroVOV2 createV2(LivroVOV2 livroVOV2) {
		// recebo um VOV2- que é meu antigo VO, que é meu antigo entity simples.
		// converto ele para livro
		Livro livro = converter.convertLivroVOToLivro(livroVOV2);
		repository.save(livro);
		// salso ele como livro no banco de dados, e conveto novamente para VO
//		LivroVOV2 vov2 = converter.convertLivroToLivroVO(repository.save(livro));
		// retorno meu VOV2
		return livroVOV2;
		
	}

	public LivroVO findById(long id) {
		Livro livro = repository.findById(id).orElseThrow();
		return DozerConverter.parseObject(livro, LivroVO.class);
	}

	public List<LivroVO> findAll() {
		return DozerConverter.parseListObjects(repository.findAll(), LivroVO.class);
	}

	public LivroVO delete(long id) {
		Livro livro = repository.findById(id).orElseThrow();

		repository.delete(livro);
		livroVO = DozerConverter.parseObject(livro, LivroVO.class);
		return livroVO;

	}

	public LivroVO update(LivroVO livroVO) {
// recebo um VO, mas uso o Id referente a esse objeto para procura meu Livro no repository
		Livro entity = repository.findById(livroVO.getId()).orElseThrow();
		// os dados do VO eu estarei inserindo no meu Lirvo(entity)
		entity.setTitulo(livroVO.getTitulo());
		entity.setAutor(livroVO.getAutor());
		entity.setCategoria(livroVO.getCategoria());
		entity.setSubCategoria(livroVO.getSubCategoria());
		entity.setNotas(livroVO.getNotas());
		entity.setImage(livroVO.getImage());
		entity.setEditora(livroVO.getEditora());
		entity.setCompra(livroVO.getCompra());
		entity.setRegistro(livroVO.getRegistro());
		// convertendo meu Lirvo(entity) para o VO
		livroVO = DozerConverter.parseObject(repository.save(entity), LivroVO.class);

		return livroVO;
	}

}
