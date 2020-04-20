package clazz.keywords.transientd._01_notseria;

import java.io.Serializable;

class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private transient String id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}