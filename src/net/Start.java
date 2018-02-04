package net;

public class Start 
{

	public static void main(String[] args) 
	{
		LogAnalyzer analyzer = new LogAnalyzer();
		
		analyzer.analyzeHourlyData();
		analyzer.printHourlyCounts();
	}

}
