package tw.lwl.mybot.data.doo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;

@Entity
@Table(name="ledger")
@Getter
@Setter
public class Ledger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;



    @Column(name = "title")
    private String title;

    @Override
    public String toString() {
        return "Ledger{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", expenditure=" + expenditure +
                '}';
    }

    @Column(name = "description")
    private String description;

    @Column(name = "expenditure")
    private Boolean expenditure;

    @OneToMany(mappedBy = "ledger", cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY)
    private List<AccountingLedger> accountledgers ;

    public Ledger() {

    }

    public Ledger(String title, String description, Boolean expenditure) {
        this.title = title;
        this.description = description;
        this.expenditure = expenditure;
    }
}
