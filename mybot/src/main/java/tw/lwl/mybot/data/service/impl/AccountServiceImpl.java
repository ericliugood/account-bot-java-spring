package tw.lwl.mybot.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.lwl.mybot.data.dao.AccountDao;
import tw.lwl.mybot.data.doo.Account;
import tw.lwl.mybot.data.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    AccountDao accountDao;

    @Override
    public Account addAccount(Account account) {
        return accountDao.save(account);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAll();
    }

    @Override
    public Account modifyAccount(Account account) {
        Account modifydata;
        modifydata=accountDao.findById(account.getId()).orElseThrow(RuntimeException::new);
        modifydata.setTitle(account.getTitle());
        modifydata.setDescription(account.getDescription());

        return accountDao.save(modifydata);
    }

    @Override
    public void removeAccountById(Long id) {
        accountDao.deleteById(id);

    }

    @Override
    public Account findAccountById(Long id) {
        return accountDao.findById(id).orElseThrow(RuntimeException::new);
    }
}
