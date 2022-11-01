package Server;

public class Main {
    public static SocketController socketController;
    public static MainScreen mainScreen;
    public static void main(String[] args) {
        mainScreen = new MainScreen();
        mainScreen.setVisible(true);
    }
}
