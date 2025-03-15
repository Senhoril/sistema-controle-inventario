package controle_inventario.inventario.service;

import controle_inventario.inventario.model.Produto;
import controle_inventario.inventario.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto moverProduto(Long produtoId, Long novaColunaId) {
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.getColuna().setId(novaColunaId); // Ajuste conforme necessário
        return produtoRepository.save(produto);
    }

    public Produto bloquearProduto(Long produtoId, String motivo) {
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setBloqueado(true);
        produto.setMotivoBloqueio(motivo);
        return produtoRepository.save(produto);
    }

    public Produto desbloquearProduto(Long produtoId, String motivo) {
        Produto produto = produtoRepository.findById(produtoId).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setBloqueado(false);
        produto.setMotivoBloqueio(motivo);
        return produtoRepository.save(produto);
    }
}
