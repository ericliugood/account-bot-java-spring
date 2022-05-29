package tw.lwl.mybot.data.service;


import tw.lwl.mybot.data.doo.AccountingLedger;



import java.util.List;

public interface AccountingLedgerService {

    public AccountingLedger addAccountingLedger(AccountingLedger accountingLedger);

    public List<AccountingLedger> findAllAccountingLedger ();
//
    public AccountingLedger modifyAccountingLedger(AccountingLedger accountingLedger);
//
    public void removeAccountingLedgerById (Long id);
//
    public AccountingLedger findAccountingLedgerById (Long id);

    public int selectTotals();

}
