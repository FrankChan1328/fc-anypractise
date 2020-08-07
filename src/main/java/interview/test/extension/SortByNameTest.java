package interview.test.extension;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import interview.Extension;
import interview.Utils;

/**
 * Question1, sort by firstName + lastName + ext, 
 * if firstName is the same then sort by lastName and
 * ext, please note lastName and ext can be empty 
 * string or null.
 **/
public class SortByNameTest extends ExtensionBaseTest{
    
    @Test
    public void sortByNameNormal() {
        List<Extension> extensions = new ArrayList<>();
        extensions.add(newExt("Elon", "Musk", "Tesla"));
        extensions.add(newExt("Bill", "Gates", "Mirosoft"));
        extensions.add(newExt("Bill", "Ack", "XFact"));
        extensions.add(newExt("Jack", "Ma", "Alibaba"));
        
        List<Extension> result = Utils.sortByName(extensions);
        // 
        // 预期:["Bill", "Ack", "XFact"],["Bill", "Gates", "Mirosoft"],["Elon", "Musk", "Tesla"],["Jack", "Ma", "Alibaba"]
        Assert.assertTrue("BillAckXFact".equals(getStr(result.get(0))));
        Assert.assertTrue("BillGatesMirosoft".equals(getStr(result.get(1))));
        Assert.assertTrue("ElonMuskTesla".equals(getStr(result.get(2))));
        Assert.assertTrue("JackMaAlibaba".equals(getStr(result.get(3))));
    }
    
    @Test
    public void sortByNameWithNull() {
        List<Extension> extensions = new ArrayList<>();
        extensions.add(newExt("Elon", "Musk", "Tesla"));
        extensions.add(newExt("Bill", "Gates", "Mirosoft"));
        extensions.add(newExt("Bill", "Ack", null));
        extensions.add(newExt("Jack", "Ma", "Alibaba"));
        extensions.add(newExt("Jack", null, "Alibaba"));
        extensions.add(newExt("Ray", "Dalio", "BridgeWater"));
        
        List<Extension> result = Utils.sortByName(extensions);
        // 
        // 预期:["Bill", "Ack", null],["Bill", "Gates", "Mirosoft"],["Elon", "Musk", "Tesla"],["Jack", "Ma", "Alibaba"]
        // ["Jack", null, "Alibaba"],["Ray", "Dalio", "BridgeWater"]
        Assert.assertTrue("BillAcknull".equals(getStr(result.get(0))));
        Assert.assertTrue("BillGatesMirosoft".equals(getStr(result.get(1))));
        Assert.assertTrue("ElonMuskTesla".equals(getStr(result.get(2))));
        Assert.assertTrue("JackMaAlibaba".equals(getStr(result.get(3))));
        Assert.assertTrue("JacknullAlibaba".equals(getStr(result.get(4))));
        Assert.assertTrue("RayDalioBridgeWater".equals(getStr(result.get(5))));
    }
    
    private String getStr(Extension extension){
        return str(extension.getFirstName()) + str(extension.getLastName()) +str(extension.getExt());
    }
}
