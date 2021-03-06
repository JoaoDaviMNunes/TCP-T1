package business;

public class Evaluation {
	
	private Integer score;
	private User evaluator;
	private EvaluationGroup group;
	private Product EvaluatedProduct;
	static public final int minScore = -3;
	static public final int maxScore = 3;
	
	public Evaluation() {
		score = null;
		
	}
	
	public Evaluation(Integer NewScore) throws IllegalArgumentException{
		setScore(NewScore);
	}
	
	public Evaluation(Product product, User evaluator) {
		setProduct(product);
		setEvaluator(evaluator);
		score = null;
		
		
		if(product != null) product.addEvaluation(this);
	
		if(evaluator != null) evaluator.addEvaluation(this);
	}
	
	
	public Evaluation(EvaluationGroup group, Product product, User evaluator) throws IllegalArgumentException{
		setGroup(group);
		setProduct(product);
		setEvaluator(evaluator);
		score = null;
		
		
		if(group == null && product == null && evaluator == null) {
			throw new IllegalArgumentException("Avaliação inicializada com parâmetros nulos\nAvaliações precisam estar associadas com pelo menos um parâmetro");
			
		}
		
		
		if(product != null) {
			product.addEvaluation(this);
			if(group != null) group.addEvaluation(product, this);
			
		
		}
	
		if(evaluator != null) evaluator.addEvaluation(this);
		
		
	}
	
	public Evaluation(EvaluationGroup group, Product product, User evaluator,Integer NewScore) throws IllegalArgumentException{
		setGroup(group);
		setProduct(product);
		setEvaluator(evaluator);
		setScore(NewScore);
		
		if(group == null && product == null && evaluator == null) {
			throw new IllegalArgumentException("Avaliação inicializada com parâmetros nulos\nAvaliações precisam estar associadas com pelo menos um parâmetro");
			
		}
		
		if(product != null) product.addEvaluation(this);
		
		if(evaluator != null) evaluator.addEvaluation(this);
		
		if(group != null) group.addEvaluation(product, this);
		
		
		
		
	}
	
	
	
	
	public void setEvaluator(User evaluator) {
		this.evaluator = evaluator;
	}
	
	public User getEvaluator() {
		return this.evaluator;
	}
	
	
	public void setGroup(EvaluationGroup group) {
		this.group = group;
	}
	
	public EvaluationGroup getGroup() {
		return this.group;
	}
	
	public void setProduct(Product product) {
		this.EvaluatedProduct = product;
	}
	
	public Product getProduct() {
		return this.EvaluatedProduct;
	}
	
	/**
	 * Lança IllegalArgumentException se a nota informada não estiver no intervalo válido
	 * <P>Intervalo de notas válidas: {@value #minScore} a {@value #maxScore}
	 * */
	public void setScore(Integer newScore ) throws IllegalArgumentException{
		if(newScore == null) {
			return;
		}
		
		if(newScore.intValue() >= minScore && newScore.intValue() <= maxScore) {
			this.score = newScore;
		}
		
		else throw new IllegalArgumentException(String.format("Notas devem estar entre %d e %d", minScore,maxScore));
	}
	
	public Integer getScore() {
			return this.score;
			
	}
	
	/**
	 * Retorna verdadeiro se há uma nota não nula associada com a avaliação
	 */
	public boolean isDone() {
		
		return score != null;
	}
	
	

}
