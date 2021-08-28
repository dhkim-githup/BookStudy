package com.study.springboot.ex24;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.ex24.service.BuyAndLogService;


@Controller
@RequestMapping("/ex24")
public class MyController_ex24 {

//    @Autowired
//    IBuyTicketService buyTicket;
    @Autowired
    BuyAndLogService buyTicketLog;

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "Transaction Propagation (4)";
    }

    @RequestMapping("/buy_ticket")
    public String buy_ticket() {
        return "ex24/buy_ticket";
        
    }
    
    @RequestMapping("/buy_ticket_card")
    public String buy_ticket_card(@RequestParam("consumerId") String consumerId,
                                  @RequestParam("amount") String amount,
                                  @RequestParam("error") String error,
                                  Model model)
    {
//        int nResult = buyTicket.buy(consumerId, Integer.parseInt(amount), error);
        int nResult = buyTicketLog.buy(consumerId, Integer.parseInt(amount), error);
        
        model.addAttribute("consumerId", consumerId);
        model.addAttribute("amount", amount);
        if (nResult == 1) {
            return "ex24/buy_ticket_end";
        } else {
            return "ex24/buy_ticket_error";
        }
    }

}
