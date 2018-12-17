package random;

public class Main {

    private static int DEF_PORT = 47372;

    public static void main(String[] args) {
        if (args.length > 0) {
            String mode = args[0];
            if ("-r".equals(mode)) {
                // reception
                int port = args.length > 1
                        ? Integer.parseInt(args[1])
                        : DEF_PORT;
                FileReceiver fs = new FileReceiver(port);
                fs.start();
            } else if ("-t".equals(mode)) {
                // transfer
                if (args.length > 3) {
                    String ip = args[1];
                    int port = Integer.parseInt(args[2]);
                    String file = args[3];
                    FileSender fc = new FileSender(ip, port, file);
                } else if (args.length > 1) {
                    String file = args[1];
                    FileSender fc = new FileSender("localhost", DEF_PORT, file);
                }
            } else if ("-h".equals(mode)
                    || "--help".equals(mode)
                    || "/h".equals(mode)
                    || "/?".equals(mode)
                    || "?".equals(mode)) {
                System.out.println("transfer.jar -r RECEIVER_PORT FILE_NAME\treceiver mode");
                System.out.println("transfer.jar -t TRANSMITTER_PORT RECEIVER_IP FILE_NAME\ttransmitter mode");
                System.out.println("transfer.jar -h\thelp");
            }
        }
    }
}
