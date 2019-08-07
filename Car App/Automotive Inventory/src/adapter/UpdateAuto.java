package adapter;

public interface UpdateAuto {
	public void updateOptionSetName(String key, String [] input);
	
	public void updateOptionPrice(String key, String modelName, String optionName, String option, float newPrice);
}
