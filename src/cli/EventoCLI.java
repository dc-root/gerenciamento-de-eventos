package cli;

import repository.EventoRepository;
import repository.ParticipanteRepository;
import services.EventoService;
import services.ParticipanteService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class EventoCLI {
    private final EventoService eventoService;
    private final ParticipanteService participanteService;
    private final Scanner scanner;

    public EventoCLI(EventoService eventoService, ParticipanteService participanteService) {
        this.eventoService = eventoService;
        this.participanteService = participanteService;

        this.scanner = new Scanner(System.in);
    }

    public void exec() {
        System.out.println("Bem-vindo ao sistema de gerenciamento de eventos!");

        while (true) {
            exibirMenu();
            Integer comando = scanner.nextInt();

            switch (comando) {
                case 1:
                    criarEvento();
                    break;
                case 2:
                    listarEventos();
                    break;
                case 3:
                    buscarEvento();
                    break;
                case 4:
                    removerEvento();
                    break;
                case 5:
                    criarParticipante();
                    break;
                case 6:
                    listarParticipantes();
                    break;
                case 7:
                    buscarParticipante();
                    break;
                case 8:
                    removerParticipante();
                    break;
                case 9:
                    System.out.println("Saindo do sistema. Até mais!");
                    return;
                default:
                    System.out.println("Comando inválido. Tente novamente.");
            }
        }
    }

    private void exibirMenu() {
        System.out.println("\nOpções disponíveis:");
        System.out.println("1. Criar evento");
        System.out.println("2. Listar eventos");
        System.out.println("3. Buscar evento por ID");
        System.out.println("4. Remover evento");
        System.out.println("5. Criar participante");
        System.out.println("6. Listar participantes");
        System.out.println("7. Buscar participante por ID");
        System.out.println("8. Remover participante");
        System.out.println("9. Sair");
        System.out.print("Digite o número da opção desejada: ");
    }

    private void criarEvento() {
        System.out.print("Digite o nome do evento: ");
        String nome = scanner.nextLine();

        System.out.print("Digite uma descrição breve do evento: ");
        String descricao = scanner.nextLine();

        System.out.print("Digite o local do evento: ");
        String local = scanner.nextLine();

        System.out.print("Digite a data do evento (YYYY-MM-DD): ");
        LocalDateTime data = LocalDateTime.parse(scanner.nextLine());

        System.out.print("Em qual categoria o evento se encaixa: ");
        String categoria = scanner.nextLine();

        eventoService.criarEvento(nome, descricao, local, data, categoria);
        System.out.println("Evento criado com sucesso!");
    }

    private void listarEventos() {
        System.out.println("Eventos cadastrados:");
        eventoService.listarEventos().forEach(System.out::println);
    }

    private void buscarEvento() {
        System.out.print("Digite o ID do evento: ");
        Long id = Long.parseLong(scanner.nextLine());

        eventoService.buscarEventoPorId(id).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Evento não encontrado.")
        );
    }

    private void removerEvento() {
        System.out.print("Digite o ID do evento que deseja remover: ");
        Long id = Long.parseLong(scanner.nextLine());

        if (eventoService.removerEvento(id)) {
            System.out.println("Evento removido com sucesso!");
        } else {
            System.out.println("Evento não encontrado.");
        }
    }

    private void criarParticipante() {
        System.out.print("Digite o nome do participante: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o email do participante: ");
        String email = scanner.nextLine();

        participanteService.criarParticipante(nome, email);
        System.out.println("Participante criado com sucesso!");
    }

    private void listarParticipantes() {
        System.out.println("Participantes cadastrados:");
        participanteService.listarParticipantes().forEach(System.out::println);
    }

    private void buscarParticipante() {
        System.out.print("Digite o ID do participante: ");
        Long id = Long.parseLong(scanner.nextLine());

        participanteService.buscarParticipantePorId(id).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Participante não encontrado.")
        );
    }

    private void removerParticipante() {
        System.out.print("Digite o ID do participante que deseja remover: ");
        Long id = Long.parseLong(scanner.nextLine());

        if (participanteService.removerParticipante(id)) {
            System.out.println("Participante removido com sucesso!");
        } else {
            System.out.println("Participante não encontrado.");
        }
    }

    public static void run() {
        // data
        EventoRepository eventoRepository = new EventoRepository();
        ParticipanteRepository participanteRepository = new ParticipanteRepository();

        // service
        EventoService eventoService = new EventoService(eventoRepository);
        ParticipanteService participanteService = new ParticipanteService(participanteRepository);

        // cli
        EventoCLI eventoCLI = new EventoCLI(eventoService, participanteService);

        eventoCLI.exec();
    }
}
