public class Command {
    private String commandWord;
    private String secondWord;
    private String thirdWord;
    private String[] args;

    /*public Command(String firstWord, String secondWord) {
        this.commandWord = firstWord;
        this.secondWord = secondWord;
    }
    public Command(String firstWord, String secondWord, String thirdWord) {
        this.commandWord = firstWord;
        this.secondWord = secondWord;
        this.thirdWord = thirdWord;
    }*/

   public Command(String commandWord, String... args) {
        this.commandWord = commandWord;
        this.args = args;
    }

    public String getCommandWord() {
        return commandWord;
    }

    public String getSecondWord() {
        return secondWord;
    }

    public String getThirdWord() {return thirdWord;}

    public boolean isUnknown() {
        return commandWord == null;
    }

    public boolean hasSecondWord() {
        return secondWord != null;
    }

    public String getArg(int index) {
        if (args == null || index < 0 || index >= args.length) {
            return null;
        }
        return args[index];
    }
    public String[] getArgs() {
        return args;
    }

    public boolean hasArgs() {
        return args != null && args.length > 0;
    }

    public boolean hasThirdWord() {return thirdWord != null;}
}
