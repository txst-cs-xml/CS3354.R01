public class ConsoleNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println(message);
    }
}
