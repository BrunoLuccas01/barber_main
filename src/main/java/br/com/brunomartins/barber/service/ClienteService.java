package br.com.brunomartins.barber.service;

import br.com.brunomartins.barber.dto.ClienteDTO;
import br.com.brunomartins.barber.model.CabeleireiroModel;
import br.com.brunomartins.barber.model.ClienteModel;
import br.com.brunomartins.barber.repository.CabeleireiroRepository;
import br.com.brunomartins.barber.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final CabeleireiroRepository cabeleireiroRepository;

    public ClienteDTO create(ClienteDTO dto) {
//        Optional<CabeleireiroModel> optionalCabeleireiro = cabeleireiroRepository.findById(cabeleireiroId);

        if (optionalCabeleireiro.isPresent()) {
            CabeleireiroModel cabeleireiro = optionalCabeleireiro.get();
            ClienteModel cliente = new ClienteModel();
            cliente.setNome(dto.getNome());
            cliente.setCabeleireiro(cabeleireiro);
            cliente = clienteRepository.save(cliente);

            return new ClienteDTO(cliente.getId(), cliente.getNome());
        } else {

            return null;
        }
    }

    public ClienteDTO findById(int id) {
        Optional<ClienteModel> optionalCliente = clienteRepository.findById(id);

        if (optionalCliente.isPresent()) {
            ClienteModel cliente = optionalCliente.get();
            return new ClienteDTO(cliente.getId(), cliente.getNome());
        } else {

            return null;
        }
    }

//    public List<ClienteModel> getClientesByCabeleireiro(int cabeleireiroId) {
//        Optional<CabeleireiroModel> optionalCabeleireiro = cabeleireiroRepository.findById(cabeleireiroId);
//
//        if (optionalCabeleireiro.isPresent()) {
//            CabeleireiroModel cabeleireiro = optionalCabeleireiro.get();
//            return cabeleireiro.getClientes();
//        } else {
//
//            return null;
//        }
//    }

    public void delete(int id) {
    }

    public List<ClienteDTO> findAll() {
        return null;
    }

    public ClienteDTO update(ClienteDTO dto) {
        return dto;
    }


}
