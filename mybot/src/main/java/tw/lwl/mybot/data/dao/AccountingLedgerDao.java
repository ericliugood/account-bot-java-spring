package tw.lwl.mybot.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import tw.lwl.mybot.data.doo.AccountingLedger;

@Repository
public interface AccountingLedgerDao extends JpaRepository<AccountingLedger, Long>, JpaSpecificationExecutor<AccountingLedger> {
}
