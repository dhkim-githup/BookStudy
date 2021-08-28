package com.study.springboot.ex24.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.study.springboot.ex24.dao.ITransaction1Dao_ex24;
import com.study.springboot.ex24.dao.ITransaction2Dao_ex24;


@Service
public class BuyTicketService_ex24  {

    @Autowired
    ITransaction1Dao_ex24 transaction1;
    @Autowired
    ITransaction2Dao_ex24 transaction2;
    
    /* 트랜잭션 처리를 하는 클래스 선언 */
      @Autowired
      TransactionTemplate transactionTemplate;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int buy(String consumerId, int amount, String error) {
    	
    	/* transaction 처리를 직접 하겠다는 선언 */
    	//TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

        try {
        	transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				
				@Override
				protected void doInTransactionWithoutResult(TransactionStatus status) {
					
				   System.out.println("==transactionTemplate==");
							
			        transaction1.pay(consumerId, amount);
            
			        // 의도적 에러 발생
			        if (error.equals("1")) { int n = 10 / 0;}
            
			        transaction2.pay(consumerId, amount);
            
			        //transactionManager.commit(status);
				}
        	});
        	
            return 1;
        } catch(Exception e) {
        	System.out.println("BuyTicketService_ex24 - Rollback");
        	//transactionManager.rollback(status);
            return 0;
        }
    }

}
