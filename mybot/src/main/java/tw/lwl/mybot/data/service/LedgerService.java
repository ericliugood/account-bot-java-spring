package tw.lwl.mybot.data.service;

import tw.lwl.mybot.data.doo.Ledger;

import java.util.List;



public interface LedgerService {

    public Ledger addLedger(Ledger ledger);

    public List<Ledger> findAllLedger ();

    public Ledger modifyLedger(Ledger ledger);

    public void removeLedgerById (Long id);

    public Ledger findLedgerById(Long id);

}
