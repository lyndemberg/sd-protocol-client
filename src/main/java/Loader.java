import connect.ClientAccess;
import model.TextMessage;

import java.io.IOException;
import java.util.Scanner;

public class Loader {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Vamos começar!!!");
        System.out.println("Digite seu nickname:");
        String nickname = entrada.nextLine();
        System.out.println("Insira o caminho da pasta local: ");
        String inbox = entrada.nextLine();
        System.out.println("Insira a pasta montada: ");
        String outbox = entrada.nextLine();
        ClientAccess clientAccess = new ClientAccess(nickname, inbox, outbox);
        System.out.println("Iniciando o chat");
        try {
            clientAccess.start();
            System.out.println("Chat funcionando.....");
            while (true) {
                String msg = entrada.nextLine();
                clientAccess.sendMessage(new TextMessage(msg));
            }
        } catch (IOException e) {
            System.out.println("Não foi possível iniciar o chat");
        }
    }
}

