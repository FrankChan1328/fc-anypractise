package rctest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import rctest.cal.BaseSaleItemGroupTask;
import rctest.cal.CalculateBaseTask;
import rctest.cal.CalculateMaxTask;
import rctest.cal.CalculateSumTask;
import rctest.cal.QuarterGroupTask;
import rctest.comparator.MultiComparator;
import rctest.comparator.extension.ExtComparator;
import rctest.comparator.extension.ExtTypeComparator;
import rctest.comparator.extension.FirstNameComparator;
import rctest.comparator.extension.LastNameComparator;

public class Utils {

    private Utils() {

    }

    //Question1
    public static List<Extension> sortByName(List<Extension> extensions) {
        if (null == extensions || extensions.isEmpty()) {
            return extensions;
        }

        List<Comparator<Extension>> multiComparators = new ArrayList<>(Arrays
                .asList(new FirstNameComparator(), new LastNameComparator(), new ExtComparator()));
        Collections.sort(extensions, new MultiComparator<>(multiComparators));
        return extensions;
    }

    //Question2
    public static List<Extension> sortByExtType(List<Extension> extensions) {
        if (null == extensions || extensions.isEmpty()) {
            return extensions;
        }
        
        List<Comparator<Extension>> multiComparators = new ArrayList<>(Arrays.asList(new ExtTypeComparator()));
        Collections.sort(extensions, new MultiComparator<>(multiComparators));
        return extensions;
    }

    //Question3
    public static List<QuarterSalesItem> sumByQuarter(List<SaleItem> saleItems) {
        if (null == saleItems || saleItems.isEmpty()) {
            return null;
        }
        BaseSaleItemGroupTask quarterGroup = new QuarterGroupTask(saleItems);
        CalculateBaseTask calTask = new CalculateSumTask();
        return calTask.calculate(quarterGroup.group());
    }

    //Question4
    public static List<QuarterSalesItem> maxByQuarter(List<SaleItem> saleItems) {
        if (null == saleItems || saleItems.isEmpty()) {
            return null;
        }
        BaseSaleItemGroupTask quarterGroup = new QuarterGroupTask(saleItems);
        CalculateBaseTask calTask = new CalculateMaxTask();
        return calTask.calculate(quarterGroup.group());
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
