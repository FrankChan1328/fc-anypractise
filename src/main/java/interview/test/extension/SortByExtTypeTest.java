package interview.test.extension;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.Extension;
import interview.Utils;

/**
 * Question2, sort extType, extType is a string and can
 * be "User", "Dept", "AO", "TMO", "Other",
 * sort by User > Dept > AO > TMO > Other;
 **/
public class SortByExtTypeTest extends ExtensionBaseTest {

    @Test
    public void sortByExtType(){
        List<Extension> extensions = new ArrayList<>();
        extensions.add(newExt("Elon", "Musk", "Tesla", "Dept"));
        extensions.add(newExt("Bill", "Gates", "Mirosoft", "User"));
        extensions.add(newExt("Bill", "Ack", "XFact", "AO"));
        extensions.add(newExt("Jack", "Ma", "Alibaba", "Other"));
        extensions.add(newExt("Bill", "Ack", "XFact", "TMO"));
        
        List<Extension> result = Utils.sortByExtType(extensions);
        // 
        // 预期:["User", "Bill", "Gates", "Mirosoft"],["Dept", "Elon", "Musk", "Tesla"],[ "AO", "Bill", "Ack", "XFact"],
        // ["TMO", "Bill", "Ack", "XFact"],["Other", "Jack", "Ma", "Alibaba"]
        Assert.assertTrue("User-BillGatesMirosoft".equals(getStr(result.get(0))));
        Assert.assertTrue("Dept-ElonMuskTesla".equals(getStr(result.get(1))));
        Assert.assertTrue("AO-BillAckXFact".equals(getStr(result.get(2))));
        Assert.assertTrue("TMO-BillAckXFact".equals(getStr(result.get(3))));
        Assert.assertTrue("Other-JackMaAlibaba".equals(getStr(result.get(4))));
    }
    
    @Test
    public void sortByExtTypeWithIllegal(){
        // 携带指定extType 之外的值：包括null
        List<Extension> extensions = new ArrayList<>();
        extensions.add(newExt("Elon", "Musk", "Tesla", "Dept"));
        extensions.add(newExt("Bill", "Gates", "Mirosoft", "User"));
        extensions.add(newExt("Bill", "Ack", "XFact", "AO"));
        extensions.add(newExt("Jack", "Ma", "Alibaba", "Other"));
        extensions.add(newExt("Bill", "Ack", "XFact", "TMO"));
        extensions.add(newExt("Ray", "Dalio", "BridgeWater", "BridgeWater"));
        extensions.add(newExt("Ellen", "Xu", "XFact", null));
        
        List<Extension> result = Utils.sortByExtType(extensions);
        // 
        // 预期:["User", "Bill", "Gates", "Mirosoft"],["Dept", "Elon", "Musk", "Tesla"],[ "AO", "Bill", "Ack", "XFact"],
        // ["TMO", "Bill", "Ack", "XFact"],["Other", "Jack", "Ma", "Alibaba"],
        // ["BridgeWater, "Ray", "Dalio", "BridgeWater"],// [null, "Ellen", "Xu", "XFact"]
        Assert.assertTrue("User-BillGatesMirosoft".equals(getStr(result.get(0))));
        Assert.assertTrue("Dept-ElonMuskTesla".equals(getStr(result.get(1))));
        Assert.assertTrue("AO-BillAckXFact".equals(getStr(result.get(2))));
        Assert.assertTrue("TMO-BillAckXFact".equals(getStr(result.get(3))));
        Assert.assertTrue("Other-JackMaAlibaba".equals(getStr(result.get(4))));
        Assert.assertTrue("BridgeWater-RayDalioBridgeWater".equals(getStr(result.get(5))));
        Assert.assertTrue("null-EllenXuXFact".equals(getStr(result.get(6))));
    }
    
    private String getStr(Extension extension) {
        return str(str(extension.getExtType()) +"-" + extension.getFirstName()) + str(extension.getLastName())
                + str(extension.getExt());
    }
}
