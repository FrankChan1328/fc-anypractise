package clazz.keywords.transientd._04_staticnotseria;

import java.io.Serializable;

class User2 implements Serializable {

    private static final long serialVersionUID = 1L;

    public static String username;
    private transient String id;

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}