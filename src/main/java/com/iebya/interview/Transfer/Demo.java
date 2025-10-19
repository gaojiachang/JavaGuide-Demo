package com.iebya.interview.Transfer;

public class Demo {
    
}

// class AccountService{
//     AccountDao accountDao;
//     LogDao logDao;
    
//     @Transactional
//     void transfer(long fromAccountId, long toAccountId, long amount){
//         // 参数检验
//         if(fromAccountId <= 0 || toAccountId <= 0 || amount <= 0){
//             throw new Exception("非法入参");
//         }
       
//         // 加锁，先加id较小的行，防止死锁
//         accountDao.addLock(Math.min(fromAccountId, toAccountId));
//         accountDao.addLock(Math.max(fromAccountId, toAccountId));
        
//         // 查询余额
//         if(accountDao.getBalance(fromAccountId) < amount){
//             throw new Exception("余额不足");
//         }
        
//         // 扣款 + 增款
//         accountDao.updateBalance(fromAccountId,-amount);
//         accountDao.updateBalance(toAccountId,amount);
        
//         //插入日志
//         logDao.addLog(fromAccountId, "Transfered " + amount +" to" + toAccountId);
//         logDao.addLog(toAccountId, "Received " + amount +" from" + fromAccountId);
//     }
// }

// /*
// account表: id, balance
// log表: id, account_id, info, time

// addLock:
//     select *
//     from account
//     where id = fromAccountId
//     for update
// */