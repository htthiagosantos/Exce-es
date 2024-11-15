package execao;

public class DominioErro extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DominioErro(String msg) {
		super(msg);
	}
	
}
