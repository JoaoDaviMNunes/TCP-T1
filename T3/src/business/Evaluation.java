package business;

public class Evaluation {
	
	private Integer score;
	private User evaluator;
	private EvaluationGroup group;
	private Product EvaluatedProduct;
	public final int minScore = -3;
	public final int maxScore = 3;
	
	public Evaluation() {
		score = null;
		
	}
	
	public Evaluation(Integer NewScore) throws IllegalArgumentException{
		setScore(NewScore);
	}
	
	public Evaluation(EvaluationGroup group, Product product, User evaluator) {
		setGroup(group);
		setProduct(product);
		setEvaluator(evaluator);
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
	
	public void setScore(Integer newScore ) throws IllegalArgumentException{
		if(newScore.intValue() >= minScore && newScore.intValue() <= maxScore) {
			this.score = newScore;
		}
		
		else throw new IllegalArgumentException(String.format("Notas devem estar entre %d e %d", minScore,maxScore));
	}
	
	public Integer getScore() {
			return this.score;
			
	}
	
	public boolean isDone() {
		return score != null;
	}

}
