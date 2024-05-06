package br.insper.aluguelBicicletas.bicicleta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BicicletaService {

    @Autowired
    private BicicletaRepository bicicletaRepository;

    public Bicicleta cadastrarBicicleta(Bicicleta bicicleta) {
        return bicicletaRepository.save(bicicleta);
    }

    public List<Bicicleta> listarBicicletas() {
        return bicicletaRepository.findAll();
    }

    public String excluirBicicleta(Integer id) {
        Optional<Bicicleta> op = bicicletaRepository.findById(id);
        if (op.isPresent()) {
            Bicicleta bike = op.get();
            bicicletaRepository.delete(bike);
            return "Bicicleta " + id + " deletada com sucesso!";
        }
        throw new BicicletaNaoEncontradaException("Bicicleta " + id + " não encontrada!");
    }

    public Bicicleta editarBicicleta(Bicicleta bicicleta) {
        Integer id = bicicleta.getId();

        Optional<Bicicleta> op = bicicletaRepository.findById(id);
        if (op.isPresent()) {
            Bicicleta bike = op.get();
            bike.setModelo(bicicleta.getModelo());
            bike.setPreco(bicicleta.getPreco());
            bike.setTipo(bicicleta.getTipo());
            bike.setStatus(bicicleta.getStatus());
            return bicicletaRepository.save(bike);
        }
        throw new BicicletaNaoEncontradaException("Bicicleta " + id + " não encontrada!");
    }

    public String mostrarStatus(Integer id) {
        Optional<Bicicleta> op = bicicletaRepository.findById(id);
        if (op.isPresent()) {
            Bicicleta bike = op.get();
            return bike.getStatus();
        }
        throw new BicicletaNaoEncontradaException("Bicicleta " + id + " não encontrada!");
    }

    public Bicicleta mudarStatus(Integer id) {
        Optional<Bicicleta> op = bicicletaRepository.findById(id);
        if (op.isPresent()) {
            Bicicleta bike = op.get();
            String status = bike.getStatus();
            if(status.equalsIgnoreCase("disponivel")){
                bike.setStatus("indisponivel");
                return bicicletaRepository.save(bike);
            }
            bike.setStatus("disponivel");
            return bicicletaRepository.save(bike);
        }
        throw new BicicletaNaoEncontradaException("Bicicleta " + id + " não encontrada!");
    }
}
