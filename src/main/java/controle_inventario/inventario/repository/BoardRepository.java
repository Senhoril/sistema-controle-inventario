package controle_inventario.inventario.repository;


import controle_inventario.inventario.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
