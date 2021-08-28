package com.study.springboot.ex22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;

import com.study.springboot.ex22.dao.ITransaction1Dao_ex22;
import com.study.springboot.ex22.dao.ITransaction2Dao_ex22;

import oracle.jdbc.internal.OracleConnection.TransactionState;


@Service
public class BuyTicketService_ex22 implements IBuyTicketService_ex22 {

    @Autowired
    ITransaction1Dao_ex22 transaction1;
    @Autowired
    ITransaction2Dao_ex22 transaction2;
    
    /* 트랜잭션 처리를 하는 클래스 선언 */
    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    TransactionDefinition transactionDefinition;

    @Override
    public int buy(String consumerId, int amount, String error) {
    	
    	/* transaction 처리를 직접 하겠다는 선언 */
    	TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

        try {
            transaction1.pay(consumerId, amount);
            
            // 의도적 에러 발생
            if (error.equals("1")) { int n = 10 / 0;}
            
            transaction2.pay(consumerId, amount);
            
            transactionManager.commit(status);
            
            return 1;
        } catch(Exception e) {
        	System.out.println("Rollback");
        	transactionManager.rollback(status);
            return 0;
        }
    }

}
