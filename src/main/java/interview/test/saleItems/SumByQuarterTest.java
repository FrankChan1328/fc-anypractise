package interview.test.saleItems;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;
import interview.QuarterSalesItem;
import interview.SaleItem;
import interview.Utils;

public class SumByQuarterTest extends SaleItemBaseTest {
    
    @Test
    public void sumByQuarterNormalTest() {
        List<SaleItem> saleItems = getDummyNormalItems();
        List<QuarterSalesItem> list = Utils.sumByQuarter(saleItems);

        Map<Integer, Double> quarterValueMap = list.stream().collect(
                Collectors.toMap(QuarterSalesItem::getQuarter, QuarterSalesItem::getValue, (key1, key2) -> key2));

        // 第一季度
        Assert.assertEquals(quarterValueMap.get(1), 135.6, 0);
        // 第二季度
        Assert.assertEquals(quarterValueMap.get(2), 222, 0);
        // 第三季度
        Assert.assertEquals(quarterValueMap.get(3), 32.82, 0);
        // 第四季度
        Assert.assertEquals(quarterValueMap.get(4), 47, 0);
    }
}
