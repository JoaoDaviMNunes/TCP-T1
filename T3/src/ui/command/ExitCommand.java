package ui.command;

public class ExitCommand extends Command {
	
	public ExitCommand(){

		super("Sair do programa",null);
	}

	@Override
	public void execute() {
		System.out.println("\nEncerrando programa...");
		System.exit(0);

	}

}
