package tw.lwl.mybot.data.doo.service;

import tw.lwl.mybot.data.doo.Account;

import java.util.List;

public interface AccountService {
    public Account addAccount(Account account);

    public List<Account> findAllAccount ();

    public Account modifyAccount(Account account);

    public void removeAccountById (Long id);

    public Account findAccountById(Long id);




}
