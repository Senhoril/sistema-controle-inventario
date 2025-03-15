package controle_inventario.inventario.repository;

import controle_inventario.inventario.model.Coluna;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColunaRepository extends JpaRepository<Coluna, Long> {
}
