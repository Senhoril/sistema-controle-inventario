package controle_inventario.inventario.repository;

import controle_inventario.inventario.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}