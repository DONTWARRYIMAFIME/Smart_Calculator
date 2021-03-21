package calculator;

public class Commands {

    private boolean exit = false;

    public void executeCommand(String str) {

        switch (str) {
            case "":
                break;
            case "/exit":
                setExit();
                break;
            case "/help":
                printHelp();
                break;
            default:
                printErrorMsg();
                break;
        }

    }

    public boolean isExit() {
        return exit;
    }

    private void setExit() {
        System.out.println("Bye!");
        exit = true;
    }

    private void printHelp() {
        String help = "The program calculates the sum of numbers";
        System.out.println(help);
    }

    private void printErrorMsg() {
        String errorMsg = "Unknown command";
        System.out.println(errorMsg);
    }

}