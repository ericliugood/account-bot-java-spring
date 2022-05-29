package tw.lwl.mybot.data.doo;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="account")
@Getter
@Setter
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "account", cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch=FetchType.LAZY)
    private List<AccountingLedger> accountledgers ;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Account() {

    }

    public Account(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
