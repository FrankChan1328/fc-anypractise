package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import interview.cal.CalStrategy;
import interview.cal.MaxStrategy;
import interview.cal.SalesContext;
import interview.cal.SumStrategy;
import interview.comparator.FieldComparator;
import interview.comparator.FieldOrderSetComparator;
import interview.comparator.MultiComparator;

public class Utils {

    /**
     * Question1, sort by firstName + lastName + ext, 
     * if firstName is the same then sort by lastName and
     * ext, please note lastName and ext can be empty 
     * string or null.
     **/
    public static List<Extension> sortByName(List<Extension> extensions) {
        if (null == extensions || extensions.isEmpty()) {
            return extensions;
        }

        List<Comparator<Extension>> multiComparators = new ArrayList<>(Arrays.asList(new FieldComparator("firstName"),
                new FieldComparator("lastName"), new FieldComparator("ext")));
        Collections.sort(extensions, new MultiComparator<>(multiComparators));
        return extensions;
    }
    
    /**
     * Question2, sort extType, extType is a string and can
     * be "User", "Dept", "AO", "TMO", "Other",
     * sort by User > Dept > AO > TMO > Other;
     **/
    public static List<Extension> sortByExtType(List<Extension> extensions) {
        List<String> orders = new ArrayList<>(Arrays.asList("User", "Dept", "AO", "TMO", "Other"));
        FieldComparator comparator = new FieldOrderSetComparator("extType", orders);
        Collections.sort(extensions, comparator);
        return extensions;
    }
	
    // Question3
    public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
        CalStrategy strategy = new SumStrategy();
        SalesContext cal = new SalesContext(saleItems, strategy);
        return cal.cal();
    }

    // Question4
    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
        CalStrategy strategy = new MaxStrategy();
        SalesContext cal = new SalesContext(saleItems, strategy);
        return cal.cal();
    }
    
	//Question5
	/**
	 * We have all Keys: 0-9;
	 * usedKeys is an array to store all used keys like :[2,3,4];
	 * We want to get all unused keys, in this example it would be: [0,1,5,6,7,8,9,]
	 */
	
	public static int[] getUnUsedKeys(int[] allKeys, int[] usedKeys) {
        if (null == allKeys || allKeys.length == 0) {
            return null;
        }

        if (null == usedKeys || usedKeys.length == 0) {
            return allKeys;
        }
        
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < usedKeys.length; i++) {
            sets.add(usedKeys[i]);
        }

        int index = 0;
        for (int i = 0; i < allKeys.length; i++) {
            if (!sets.contains(allKeys[i])) {
                allKeys[index] = allKeys[i];
                index++;
            }
        }
        return Arrays.copyOfRange(allKeys, 0, index);
	}
	
}
