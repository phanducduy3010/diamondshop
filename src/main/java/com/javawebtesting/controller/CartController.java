package com.javawebtesting.controller;

import com.javawebtesting.dto.CartDTO;
import com.javawebtesting.entity.Bill;
import com.javawebtesting.entity.User;
import com.javawebtesting.service.user.IBillService;
import com.javawebtesting.service.user.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
public class CartController extends BaseController {

    @Autowired
    private ICartService cartService;

    @Autowired
    IBillService billService;

    @RequestMapping(value = "gio-hang")
    public  ModelAndView index() {
        _mvShare.setViewName("user/list_cart");
        return _mvShare;
    }

    @RequestMapping(value="addcart/{id}")
    public String addCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
        if(cart == null) {
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartService.addCart(id, cart);
        session.setAttribute("cart", cart);
        session.setAttribute("totalQuantityCart", cartService.getTotalProductsInCart(cart));
        session.setAttribute("totalPriceCart", cartService.getTotalPrice(cart));
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value="editcart/{id}/{quantity}")
    public String editCart(HttpServletRequest request, HttpSession session, @PathVariable long id, @PathVariable int quantity) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
        if(cart == null) {
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartService.editCart(id, quantity, cart);
        session.setAttribute("cart", cart);
        session.setAttribute("totalQuantityCart", cartService.getTotalProductsInCart(cart));
        session.setAttribute("totalPriceCart", cartService.getTotalPrice(cart));
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value="deletecart/{id}")
    public String deleteCart(HttpServletRequest request, HttpSession session, @PathVariable long id) {
        HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
        if(cart == null) {
            cart = new HashMap<Long, CartDTO>();
        }
        cart = cartService.deleteCart(id, cart);
        session.setAttribute("cart", cart);
        session.setAttribute("totalQuantityCart", cartService.getTotalProductsInCart(cart));
        session.setAttribute("totalPriceCart", cartService.getTotalPrice(cart));
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(value = "checkout", method = RequestMethod.GET)
    public ModelAndView checkout(HttpServletRequest request, HttpSession session) {
        _mvShare.setViewName("user/checkout");
        Bill bill = new Bill();
        User loginInfo = (User)session.getAttribute("loginInfo");
        if(loginInfo != null) {
            bill.setAddress(loginInfo.getAddress());
            bill.setDisplay_name(loginInfo.getDisplay_name());
            bill.setUsername(loginInfo.getUsername());
        } else {
            _mvShare.setViewName("redirect:dang-ky");
        }
        _mvShare.addObject("bill", bill);
        return _mvShare;
    }

    @RequestMapping(value = "checkout", method = RequestMethod.POST)
    public String checkoutBill(HttpServletRequest request, HttpSession session, @ModelAttribute("bill") Bill bill) {
        bill.setQuantity((Integer)session.getAttribute("totalQuantityCart"));
        bill.setTotal((Double)session.getAttribute("totalPriceCart"));
        if(billService.addBill(bill) > 0) {
            HashMap<Long, CartDTO> cart = (HashMap<Long, CartDTO>) session.getAttribute("cart");
            billService.addBillDetails(cart);
        }
        session.removeAttribute("cart");
        return "redirect:gio-hang";
    }
}
