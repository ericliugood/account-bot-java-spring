package tw.lwl.mybot.data.doo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.lwl.mybot.data.dao.LedgerDao;
import tw.lwl.mybot.data.doo.Ledger;
import tw.lwl.mybot.data.doo.service.LedgerService;

import java.util.List;

@Service
public class LedgerServiceImpl implements LedgerService {

    @Autowired
    LedgerDao ledgerDao;

    @Override
    public Ledger addLedger(Ledger ledger) {
        return ledgerDao.save(ledger);
    }

    @Override
    public List<Ledger> findAllLedger() {
        return ledgerDao.findAll();
    }

    @Override
    public Ledger modifyLedger(Ledger ledger) {
        Ledger modifydata;
        modifydata = ledgerDao.findById(ledger.getId()).orElseThrow(RuntimeException::new);
        modifydata.setTitle(ledger.getTitle());
        modifydata.setDescription(ledger.getDescription());
        modifydata.setExpenditure(ledger.getExpenditure());
        return ledgerDao.save(modifydata);
    }

    @Override
    public void removeLedgerById(Long id) {
        ledgerDao.deleteById(id);

    }

    @Override
    public Ledger findLedgerById(Long id) {
        return ledgerDao.findById(id).orElseThrow(RuntimeException::new);
    }
}
