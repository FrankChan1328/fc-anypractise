package interview.test.saleItems;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import interview.SaleItem;

public class SaleItemBaseTest {

    public SaleItem newItem(int month, Date date, String transationId, double saleNumbers) {
        SaleItem item = new SaleItem();
        item.setMonth(month);
        item.setDate(date);
        item.setSaleNumbers(saleNumbers);
        item.setTransationId(transationId);
        return item;
    }
    
    public List<SaleItem> getDummyNormalItems() {
        List<SaleItem> saleItems = new ArrayList<>();
        saleItems.add(newItem(1, parse("2019-01-05 12:00:00"), "id_1", 20));
        saleItems.add(newItem(2, parse("2019-02-05 12:00:00"), "id_2", 100));
        saleItems.add(newItem(3, parse("2019-03-05 12:00:00"), "id_3", 15.6));
        
        saleItems.add(newItem(4, parse("2019-04-05 12:00:00"), "id_4", 0));
        saleItems.add(newItem(5, parse("2019-05-05 12:00:00"), "id_5", 200));
        saleItems.add(newItem(6, parse("2019-06-05 12:00:00"), "id_6", 22));
        
        saleItems.add(newItem(7, parse("2019-08-05 12:00:00"), "id_7", 10));
        saleItems.add(newItem(8, parse("2019-08-05 12:00:00"), "id_7", 2.82));
        saleItems.add(newItem(9, parse("2019-09-05 12:00:00"), "id_8", 20));
        
        saleItems.add(newItem(10, parse("2019-10-05 12:00:00"), "id_9", 20));
        saleItems.add(newItem(11, parse("2019-11-05 12:00:00"), "id_10", 7));
        saleItems.add(newItem(12, parse("2019-12-05 12:00:00"), "id_11", 20));
        return saleItems;
    }
    
    public Date parse(String str) {
        if (null == str) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return sdf.parse(str);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
