package controle_inventario.inventario.service;

import controle_inventario.inventario.model.Board;
import controle_inventario.inventario.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public List<Board> listarBoards() {
        return boardRepository.findAll();
    }

    public Board criarBoard(Board board) {
        return boardRepository.save(board);
    }

    public void excluirBoard(Long id) {
        boardRepository.deleteById(id);
    }
}
