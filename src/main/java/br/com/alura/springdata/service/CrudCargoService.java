package br.com.alura.springdata.service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private final CargoRepository repository;

    public CrudCargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        salvar(scanner);
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descrição do Cargo:");
        String descricao = scanner.nextLine();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        repository.save(cargo);
        System.out.println("Cargo salvo.");
    }

}
