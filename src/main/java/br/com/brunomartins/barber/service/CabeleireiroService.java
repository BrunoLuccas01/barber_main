package br.com.brunomartins.barber.service;

import br.com.brunomartins.barber.dto.CabeleireiroDTO;
import br.com.brunomartins.barber.dto.ClienteDTO;
import br.com.brunomartins.barber.model.CabeleireiroModel;
import br.com.brunomartins.barber.model.ClienteModel;
import br.com.brunomartins.barber.repository.CabeleireiroRepository;
import br.com.brunomartins.barber.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabeleireiroService {

    @Autowired
    private CabeleireiroRepository cabeleireiroRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public CabeleireiroDTO create(CabeleireiroDTO dto) {
        CabeleireiroModel cabeleireiro = new CabeleireiroModel();
        cabeleireiro.setNome(dto.getNome());
        cabeleireiro = cabeleireiroRepository.save(cabeleireiro);

        return new CabeleireiroDTO(cabeleireiro.getId(), cabeleireiro.getNome());
    }

    public CabeleireiroDTO findById(int id) {
        Optional<CabeleireiroModel> optionalCabeleireiro = cabeleireiroRepository.findById(id);

        if (optionalCabeleireiro.isPresent()) {
            CabeleireiroModel cabeleireiro = optionalCabeleireiro.get();
            return new CabeleireiroDTO(cabeleireiro.getId(), cabeleireiro.getNome());
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

    public ClienteDTO createCliente(int cabeleireiroId, ClienteDTO clienteDTO) {
        Optional<CabeleireiroModel> optionalCabeleireiro = cabeleireiroRepository.findById(cabeleireiroId);

        if (optionalCabeleireiro.isPresent()) {
            CabeleireiroModel cabeleireiro = optionalCabeleireiro.get();
            ClienteModel cliente = new ClienteModel();
            cliente.setNome(clienteDTO.getNome());
            cliente.setCabeleireiro(cabeleireiro);
            cliente = clienteRepository.save(cliente);

            return new ClienteDTO(cliente.getId(), cliente.getNome(), cabeleireiroId);
        } else {

            return null;
        }
    }


    public void delete(CabeleireiroDTO dto) {
    }

    public CabeleireiroDTO update(CabeleireiroDTO dto) {
        return dto;
    }

    public Page<CabeleireiroDTO> findAll(Pageable pageable) {
        return null;
    }


}
