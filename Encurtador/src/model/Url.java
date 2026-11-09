
package model;

import java.util.Objects;

public class Url {
    
    String Url;

    public Url(String Url) {
        this.Url = Url;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    @Override
    public String toString() {
        return "Url Original : {" + "Url=" + Url + '}';
    }
    
     @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.Url);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Url other = (Url) obj;
        return Objects.equals(this.Url, other.Url);
    }

    
    
}
