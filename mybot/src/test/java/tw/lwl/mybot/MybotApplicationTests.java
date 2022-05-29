package tw.lwl.mybot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tw.lwl.mybot.data.doo.Account;
import tw.lwl.mybot.data.doo.AccountingLedger;
import tw.lwl.mybot.data.doo.Ledger;
import tw.lwl.mybot.data.service.AccountService;
import tw.lwl.mybot.data.service.AccountingLedgerService;
import tw.lwl.mybot.data.service.LedgerService;

import java.util.List;

@SpringBootTest
class MybotApplicationTests {



    @Autowired
    private AccountService accountService;

    @Autowired
    private LedgerService ledgerService;


    @Autowired
    private AccountingLedgerService accountingLedgerService;

    @Test
    void addaccount() {
        Account account = new Account("小打打碧","打打2");
        Account account2;
        account2=accountService.addAccount(account);
        System.out.println(account2);

    }

    @Test
    void addledger(){
        Ledger ledger = new Ledger("大大紙","大大喔喔哭喔",true);
        ledgerService.addLedger(ledger);

    }

    @Test
    void findaccount(){
        List<Account> accounts =accountService.findAllAccount();
        System.out.println(accounts);
    }

    @Test
    void modifyaccount(){
        Account account =new Account("2帳戶8股8","aaaaa");
        account.setId(2L);
        Account account2;
        account2=accountService.modifyAccount(account);
        System.out.println(account2);
    }

    @Test
    void deleteaccount(){
        accountService.removeAccountById(1L);
    }

    @Test
    void modifyledger(){
        Ledger ledger = new Ledger("股票所得","股8喔8喔",false);
        ledger.setId(1L);
        Ledger ledger2;
        ledger2=ledgerService.modifyLedger(ledger);
        System.out.println(ledger2);



    }

    @Test
    void deleteledger(){
        ledgerService.removeLedgerById(4L);
    }

    @Test
    void findledger(){
        List<Ledger> ledgers =ledgerService.findAllLedger();
        System.out.println(ledgers);
    }

    @Test
    void findaccountid(){
        Account account =accountService.findAccountById(1L);
        System.out.println(account);
    }

    @Test
    void findledgerid(){
        Ledger ledger =ledgerService.findLedgerById(1L);
        System.out.println(ledger);
    }

    @Test
    void addAccountingLedger(){
        Account account =accountService.findAccountById(2L);
        Ledger ledger = ledgerService.findLedgerById(4L);
        AccountingLedger accountingLedger = new AccountingLedger(account,ledger,590);
        AccountingLedger accountingLedger2;
        accountingLedger2 = accountingLedgerService.addAccountingLedger(accountingLedger);

        System.out.println(accountingLedger2);

    }

    @Test
    void findAccountingLedger(){
        List<AccountingLedger> accountingLedgers = accountingLedgerService.findAllAccountingLedger();

        System.out.println(accountingLedgers);



    }

    @Test
    void modifyAccountingLedger(){
        Account account =accountService.findAccountById(4L);
        Ledger ledger = ledgerService.findLedgerById(3L);
        AccountingLedger accountingLedger = new AccountingLedger(account,ledger,1005000);
        accountingLedger.setId(3L);
        AccountingLedger accountingLedger2;
        accountingLedger2 = accountingLedgerService.modifyAccountingLedger(accountingLedger);

        System.out.println(accountingLedger2);

    }

    @Test
    void deleteAccountingLedger(){

        accountingLedgerService.removeAccountingLedgerById(4L);



    }

    @Test
    void FindAccountingLedgerById(){
        AccountingLedger accountingLedger = accountingLedgerService.findAccountingLedgerById(5L);

        System.out.println(accountingLedger);



    }





}
