package tw.lwl.mybot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import tw.lwl.mybot.data.doo.Account;
import tw.lwl.mybot.data.doo.AccountingLedger;
import tw.lwl.mybot.data.doo.Ledger;
import tw.lwl.mybot.data.service.AccountService;
import tw.lwl.mybot.data.service.AccountingLedgerService;
import tw.lwl.mybot.data.service.LedgerService;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private LedgerService ledgerService;


    @Autowired
    private AccountingLedgerService accountingLedgerService;

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", "Hello Wodrld!!!");
        return "hello";
    }

    @GetMapping("/alltrans")
    public String alltrans(Model model) {

        List<Account>  accounts = accountService.findAllAccount();
        List<Ledger> ledgers = ledgerService.findAllLedger();
        List<AccountingLedger> accountingLedgers = accountingLedgerService.findAllAccountingLedger();

        model.addAttribute("accounts", accounts);
        model.addAttribute("ledgers", ledgers);
        model.addAttribute("accountingLedgers",accountingLedgers);

        return "alltrans";
    }

    @GetMapping("/accountform")
    public String accountform(Model model) {
        Account account =new Account();
        model.addAttribute("account",account);

        return "accountform";
    }

    @PostMapping("/addaccount")
    public String addaccount(@ModelAttribute Account account, Model model) {

        accountService.addAccount(account);

        model.addAttribute("account",account);


        return "redirect:/alltrans";
    }


    @GetMapping("/ledgerform")
    public String ledgerform(Model model) {
        Ledger ledger = new Ledger();
        model.addAttribute("ledger",ledger);

        return "ledgerform";
    }

    @PostMapping("/addledger")
    public String addledger(@ModelAttribute Ledger ledger, Model model) {

        ledgerService.addLedger(ledger);

        model.addAttribute("ledger",ledger);


        return "redirect:/alltrans";
    }

    @GetMapping("/accountingledgerform")
    public String accountingledgerform(Model model) {
        AccountingLedger accountingLedger = new AccountingLedger();
        List<Account>  accounts = accountService.findAllAccount();
        List<Ledger> ledgers = ledgerService.findAllLedger();


        model.addAttribute("accounts", accounts);
        model.addAttribute("ledgers", ledgers);

        model.addAttribute("accountingLedger",accountingLedger);

        return "accountingledgerform";
    }

    @PostMapping("/addaccountingledger")
    public String addaccountingledger(@ModelAttribute AccountingLedger accountingLedger, Model model) {

        accountingLedgerService.addAccountingLedger(accountingLedger);

        model.addAttribute("accountingLedger",accountingLedger);


        return "redirect:/alltrans";
    }

}
