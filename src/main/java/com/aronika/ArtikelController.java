package com.aronika;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 *
 * @author Weronzha
 */

@ManagedBean
@ViewScoped
public class ArtikelController implements Serializable {
    static final long serialVersionUID = 4L;

    private int index = 0;

    public Artikel getArtikel() {
        System.out.println("The value of the index when we get artikel " + this.index);
        return Shop.getInstance().getSortiment().get(this.index);
    }

    public int getIndex() {
        System.out.println("The index is " + this.index);
        return this.index;
    }

    public void vor() {
        System.out.println("the value of the index when we press vor " + this.index);
        System.out.println(this);
        if (this.index < Shop.getInstance().getSortiment().size() - 1) {
            this.index++;
            System.out.println("The index has changed to " + this.index);
        }
    }

    public void zurueck() {
        System.out.println("the value of the index when we press zueruck " + this.index);
        System.out.println(this);
        if (this.index > 0) {
            this.index--;
            System.out.println("The index has changed to " + this.index);
        }
    }

}