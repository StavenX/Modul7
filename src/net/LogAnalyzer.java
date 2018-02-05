package net;

/**
 * Read web server data and analyse hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version    2016.02.29
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasNext()) {
            LogEntry entry = reader.next();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }
    
    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }
    
    /**
     * Prints the busiest hour in the entry
     * @author Staven
     */
    public void busiestHour() 
    {
    	int hour = 0;
    	int highestEntry = 0;
    	
    	for (int i = 0; i < hourCounts.length; i++)
    	{
    		if (hourCounts[i] > highestEntry)
    		{
    			highestEntry = hourCounts[i];
    			hour = i;
    		}
    	}
    	
    	System.out.println(
    		String.format("Hour %d was the busiest hour with %d entries.",
    			hour,
    			highestEntry
    		)		
    	);
    }
 
    /**
     * Prints the least busiest hour in the entry
     * @author Staven
     */
    public void quietestHour()
    {
    	int hour = 0;
    	int lowestEntry = Integer.MAX_VALUE;
    	
    	for (int i = 0; i < hourCounts.length; i++)
    	{
    		if (hourCounts[i] < lowestEntry)
    		{
    			lowestEntry = hourCounts[i];
    			hour = i;
    		}
    	}
    	
    	System.out.println(
    		String.format("Hour %d was the quietest hour with %d entries.",
    			hour,
    			lowestEntry
    		)
    	);
    }    
}