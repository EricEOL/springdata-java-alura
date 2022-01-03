package br.com.alura.springdata.service;

import br.com.alura.springdata.orm.Cargo;
import br.com.alura.springdata.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudCargoService {

    private Boolean system = true;

    private final CargoRepository repository;

    public CrudCargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public void inicial(Scanner scanner) {
        while (system) {
            System.out.println("Qual ação de cargo você deseja?");
            System.out.println("0 - Sair");
            System.out.println("1 - Salvar");
            System.out.println("2 - Atualizar");

            int action = Integer.parseInt(scanner.nextLine());

            switch (action) {
                case 2:
                    atualizar(scanner);
                    break;
                case 1:
                    salvar(scanner);
                    break;
                case 0:
                    system = false;
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void salvar(Scanner scanner) {
        System.out.println("Descrição do Cargo:");
        String descricao = scanner.nextLine();

        Cargo cargo = new Cargo();
        cargo.setDescricao(descricao);

        repository.save(cargo);
        System.out.println("Cargo salvo.");
    }

    private void atualizar(Scanner scanner) {
        System.out.println("Qual o id do cargo ?");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Descrição do Cargo:");
        String descricao = scanner.nextLine();

        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescricao(descricao);

        repository.save(cargo);
        System.out.println("Cargo: " + id + " | atualizado.");
    }

}
