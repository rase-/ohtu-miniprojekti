
package wad.spring.service;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.validation.BindingResult;
import wad.spring.domain.ReferenceType;
import wad.spring.domain.Reference;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;

@Service
public class ValidateServiceImpl implements ValidateService{
    


    private String author;
    private String title;
    private String publishingYear;
    private String publisher;    
    private String pages;   
    private String address;   
    private String booktitle;
    private String journal;
    private String note;


    
    @Override   
    public BindingResult Validate(BindingResult result, Reference reference) {

        this.author = reference.getAuthor();
        this.title = reference.getTitle();
        this.publishingYear = reference.getPublishingYear();
        this.publisher = reference.getPublisher();
        this.pages = reference.getPages();
        this.address = reference.getPages();
        this.booktitle = reference.getBooktitle();
        this.journal = reference.getJournal();
        this.note = reference.getNote();
        
        if (!author.matches("[^<>$%]+")) {
            result.addError(new FieldError("reference", "author", "There has to be an author and it should not contain <>$%"));
        }
        if (!title.matches("[^<>$%]+")) {
            result.addError(new FieldError("reference", "title","There should be a title and it should not contain <>$%" ));
        }
        if (!publishingYear.matches("[0-9]{4}")) {
            result.addError(new FieldError("reference", "publishingYear", "Year should contain exactly 4 numbers and should not be left empty"));
        }
        if (!publisher.matches("[^<>$%]*")) {
            result.addError(new FieldError("reference", "publisher", "Publisher should not contain <>$%"));
        }
        if (!pages.matches("([0-9]+-{1}[0-9]+)?")) {
            result.addError(new FieldError("reference", "pages", "Pages should consist of a number, a line and a number"));         
        }
        if (!address.matches("[^<>$%]*")) {
            result.addError(new FieldError("reference", "address", "Address should not contain <>$%"));
        }
        if (!booktitle.matches("[^<>$%]*")) {
            result.addError(new FieldError("reference", "booktitle", "Booktitle should not contain <>$%"));
        }
        if (!journal.matches("[^<>$%]*")) {
            result.addError(new FieldError("reference", "journal", "Journal should not contain <>$%"));
        }
        if (!note.matches("[^<>$%]*")) {
            result.addError(new FieldError("reference", "note", "Note should not contain <>$%"));
        }
        return result;
    }
    
}
