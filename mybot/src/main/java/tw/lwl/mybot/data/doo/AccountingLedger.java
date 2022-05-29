package tw.lwl.mybot.data.doo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="accountingLedger")
@Getter
@Setter
public class AccountingLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    Account account;


    @ManyToOne
    @JoinColumn(name = "ledger_id")
    Ledger ledger;

    @Column(name = "money")
    private int money;

    public AccountingLedger() {

    }

    @Override
    public String toString() {
        return "AccountingLedger{" +
                "id=" + id +
                ", account_id=" + account.getId() +
                ", ledger_id=" + ledger.getId() +
                ", money=" + money +
                '}';
    }

    public AccountingLedger(Account account, Ledger ledger, int money) {
        this.account = account;
        this.ledger = ledger;
        this.money = money;
    }
}
