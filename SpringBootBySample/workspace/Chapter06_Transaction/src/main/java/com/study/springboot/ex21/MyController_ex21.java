package com.study.springboot.ex21;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.ex21.service.IBuyTicketService;


@Controller
@RequestMapping("/ex21")
public class MyController_ex21 {

    @Autowired
    IBuyTicketService buyTicket;

    @RequestMapping("/")
    public @ResponseBody String root() throws Exception{
        return "Transaction X (1)";
    }

    @RequestMapping("/buy_ticket")
    public String buy_ticket() {
        return "ex21/buy_ticket";
        
    }
    
    @RequestMapping("/buy_ticket_card")
    public String buy_ticket_card(@RequestParam("consumerId") String consumerId,
                                  @RequestParam("amount") String amount,
                                  @RequestParam("error") String error,
                                  Model model)
    {
        int nResult = buyTicket.buy(consumerId, Integer.parseInt(amount), error);
        
        model.addAttribute("consumerId", consumerId);
        model.addAttribute("amount", amount);
        if (nResult == 1) {
            return "ex21/buy_ticket_end";
        } else {
            return "ex21/buy_ticket_error";
        }
    }

}
