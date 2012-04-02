/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wad.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author tonykova
 */

@Entity
public class Reference {
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
    private int volume;
    private int number;
    
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

}
