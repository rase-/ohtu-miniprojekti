/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author tonykova
 */
@Entity
public class Reference implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private ReferenceType type;
    private String author;
    private String title;
    private String publishingYear;
    private String publisher;
    private String pages;
    private String address;
    private String booktitle;
    private String journal;
    private String note;
    private int volume;
    private int number;
    private String referenceCite;
    private List<String> tag;

    public boolean equals(Object o) {
        if (o instanceof Reference) {
            Reference r = (Reference) o;
            if (r.getId() == this.id) {
                return true;
            }
            return false;
        }
        return false;
    }

    public Reference() {
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(ReferenceType type) {
        this.type = type;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getReferenceCite() {
        return referenceCite;
    }

    public void setReferenceCite(String referenceCite) {
        this.referenceCite = referenceCite;
    }

    public String getAddress() {
        return address;
    }

    public String getAuthor() {
        return author;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public String getJournal() {
        return journal;
    }

    public int getNumber() {
        return number;
    }

    public String getPages() {
        return pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public String getTitle() {
        return title;
    }

    public ReferenceType getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<String> getTag() {
        return tag;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }
    
    public String toString() {
//        String palautettava = "@" + this.type.toString().toLowerCase() + "{" + this.getReferenceCite() + ",\n"
//                + "author = {" + this.author + "},\n"
//                + "title = {" + this.title + "},\n"
//                + "year = {" + this.publishingYear + "},\n"
//                + "publisher = {" + this.publisher + "},\n"
//                + "booktitle = {" + this.booktitle + "},\n"
//                + "pages = {" + this.pages + "},\n"
//                + "address = {" + this.address + "},\n"
//                + "journal = {" + this.journal + "},\n"
//                + "volume = {" + this.volume + "},\n"
//                + "number = {" + this.number + "},\n"
//                + "note = {" + this.note + "},\n";
        if (this.type == null) {
            return "Virhe! Ei tyyppiä!";
        }
        
        if (this.referenceCite == null) {
            this.referenceCite = "";
        }
        
        String palautettava = "@" + this.type.toString().toLowerCase() + "{" + this.referenceCite + ",\n";
        
        if (author != null && !author.isEmpty()) {
            palautettava += "author = {" + this.author + "},\n";

        }
        if (title != null && !author.isEmpty()) {
            palautettava += "title = {" + this.title + "},\n";
        }
        if (publishingYear != null && !author.isEmpty()) {
            palautettava += "year = {" + this.publishingYear + "},\n";
        }
        if (publisher != null && !publisher.isEmpty()) {
            palautettava += "publisher = {" + this.publisher + "},\n";
        }
        if (booktitle != null && !booktitle.isEmpty()) {
            palautettava += "booktitle = {" + this.booktitle + "},\n";
        }
        if (pages != null && !pages.isEmpty()) {
            palautettava += "pages = {" + this.pages + "},\n";
        }
        if (address != null && !address.isEmpty()) {
            palautettava += "address = {" + this.address + "},\n";
        }
        if (journal != null && !journal.isEmpty()) {
            palautettava += "journal = {" + this.journal + "},\n";
        }
        if (volume > 0) {
            palautettava += "volume = {" + this.volume + "},\n";
        }
        if (number > 0) {
            palautettava += "number = {" + this.number + "},\n";
        }
        if (note != null && !note.isEmpty()) {
            palautettava += "note = {" + this.note + "},\n";
        }
        palautettava += "}";
        return palautettava;
    }
//    @article{W04,
//author = {Whittington, Keith J.},
//title = {Infusing active learning into introductory programming courses},
//journal = {J. Comput. Small Coll.},
//volume = {19},
//number = {5},
//year = {2004},
//pages = {249--259},
//publisher = {Consortium for Computing Sciences in Colleges},
//address = {USA},
//}
}
