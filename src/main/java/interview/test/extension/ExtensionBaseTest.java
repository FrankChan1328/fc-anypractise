package interview.test.extension;

import interview.Extension;

public abstract class ExtensionBaseTest {

    public String str(String string) {
        return null == string ? "null" : string;
    }
    
    public Extension newExt(String firstName, String lastName, String ext) {
        Extension extsion = new Extension();
        extsion.setFirstName(firstName);
        extsion.setLastName(lastName);
        extsion.setExt(ext);
        return extsion;
    }

    public Extension newExt(String firstName, String lastName, String ext, String extType) {
        Extension extsion = newExt(firstName, lastName, ext);
        extsion.setExtType(extType);
        return extsion;
    }
}
